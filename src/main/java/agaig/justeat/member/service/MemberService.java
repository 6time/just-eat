package agaig.justeat.member.service;

import agaig.justeat.member.domain.Member;
import agaig.justeat.member.dto.MemberUpdateResponseDto;
import agaig.justeat.member.dto.MemberSaveRequestDto;
import agaig.justeat.member.dto.MemberUpdateRequestDto;
import agaig.justeat.member.exception.ErrorCode;
import agaig.justeat.member.exception.SignInException;
import agaig.justeat.member.repository.MemberRepository;
import agaig.justeat.member.util.MemberSha256;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long join(MemberSaveRequestDto requestDto) {
        Optional.ofNullable(memberRepository.findByEmail(requestDto.getEmail()))
                .ifPresent((member -> {
                    throw new SignInException("이미 존재하는 회원입니다.", ErrorCode.ADMIN_NOT_FOUND);
                }));
        requestDto.setPassword(MemberSha256.encrypt(requestDto.getPassword()));
        return memberRepository.insert(requestDto.toEntity());
    }

    public Long signIn(String email, String password) {
        Member member = Optional.ofNullable(memberRepository.findByEmail(email)).orElseThrow(() -> new SignInException("존재하지 않는 회원 입니다.", ErrorCode.ADMIN_NOT_FOUND));
        String encryptPassword = MemberSha256.encrypt(password);
        if (!encryptPassword.equals(member.getPassword())) {
            throw new SignInException("틀린 비밀번호 입니다.", ErrorCode.ADMIN_NOT_FOUND);
        }
        return member.getMember_id();
    }

    public void signInCheck(HttpSession session) {
        Optional.ofNullable(session.getAttribute("session"))
                .orElseThrow(() ->
                        new SignInException("로그인이 필요합니다.", ErrorCode.ADMIN_NOT_FOUND));
    }

    public void verify(Long member_id, HttpSession session) {
        if (!member_id.equals(session.getAttribute("session"))) {
            throw new SignInException("잘못된 접근입니다.", ErrorCode.ADMIN_NOT_FOUND);
        }
    }

    public void passwordCheck(Long member_id, String password) {
        Member member = memberRepository.findById(member_id);
        String encryptPassword = MemberSha256.encrypt(password);
        if (!encryptPassword.equals(member.getPassword())) {
            throw new SignInException("틀린 비밀번호 입니다.", ErrorCode.ADMIN_NOT_FOUND);
        }
    }

    public Long update(Long member_id, MemberUpdateRequestDto requestDto) {
        requestDto.setMember_id(member_id);
        return memberRepository.update(requestDto.toEntity());
    }

    public MemberUpdateResponseDto findInfoById(Long member_id) {
        Member member = Optional.ofNullable(memberRepository.findById(member_id)).orElseThrow(()->new SignInException("존재하지 않는 회원 입니다.", ErrorCode.ADMIN_NOT_FOUND));
        return new MemberUpdateResponseDto(member);
    }


    public String getAccessToken(String authorize_code) {
        String access_token = "";
        String refresh_token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=5739de64ac097aace6fd7e1231e8f94b");
            sb.append("&redirect_uri=http://localhost:3070/members/kakao");
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_token);
            System.out.println("refresh_token : " + refresh_token);

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return access_token;
    }

    public HashMap<String, Object> getUserInfo(String access_Token) {

        HashMap<String, Object> userInfo = new HashMap<String, Object>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            long id = element.getAsJsonObject().get("id").getAsLong();
            String nickname = properties.getAsJsonObject().get("nickname").getAsString();
            String email = kakao_account.getAsJsonObject().get("email").getAsString();
            String age = kakao_account.getAsJsonObject().get("age_range").getAsString();
            String gender = kakao_account.getAsJsonObject().get("gender").getAsString();

            userInfo.put("nickname", nickname);
            userInfo.put("email", email);
            userInfo.put("age", age);
            userInfo.put("id", id);
            userInfo.put("gender", gender);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInfo;
    }
}
