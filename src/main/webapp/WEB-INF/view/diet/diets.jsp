<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
    <head>
      <meta charset="UTF-8" />
      <link rel="icon" href="/img/just-eat-r-128.png" />
      <title>식단 | Just Eat</title>
      <link rel="stylesheet" href="/css/diet.css" />
   </head>
   <body>
        <div class="diet-out-box">
            <img class="icon" src="/img/just-eat-r-1280.png" style="height: 120px; margin-top: 50px;" />
                <div class="diet-title">${name}님의 식단</div>

                <div class="diet-box">
                    <div class="diet">
                        <center><h4>월요일</h4></center>
                        ${product1.product_name}<br>
                        총 내용량 : ${product1.product_size}g<br>
                        총 열량 : ${product1.kcal}kcal<br>
                        단백질 : ${product1.protein}g<br>
                        탄수화물 : ${product1.carb}g<br>
                        지방 : ${product1.fat}g<br>
                        당 : ${product1.sugars}g<br>
                        나트륨 : ${product1.sodium}mmg<br>
                        가격 : ${product1.price}원<br>
                    </div>

                    <div class="diet">
                        <center><h4>화요일</h4></center>
                        ${product2.product_name}<br>
                        총 내용량 : ${product2.product_size}g<br>
                        총 열량 : ${product2.kcal}kcal<br>
                        단백질 : ${product2.protein}g<br>
                        탄수화물 : ${product2.carb}g<br>
                        지방 : ${product2.fat}g<br>
                        당 : ${product2.sugars}g<br>
                        나트륨 : ${product2.sodium}mmg<br>
                        가격 : ${product2.price}원<br>
                    </div>

                    <div class="diet">
                        <center><h4>수요일</h4></center>
                        ${product3.product_name}<br>
                        총 내용량 : ${product3.product_size}g<br>
                        총 열량 : ${product3.kcal}kcal<br>
                        단백질 : ${product3.protein}g<br>
                        탄수화물 : ${product3.carb}g<br>
                        지방 : ${product3.fat}g<br>
                        당 : ${product3.sugars}g<br>
                        나트륨 : ${product3.sodium}mmg<br>
                        가격 : ${product3.price}원<br>
                    </div>

                    <div class="diet">
                        <center><h4>목요일</h4></center>
                            ${product3.product_name}<br>
                            총 내용량 : ${product4.product_size}g<br>
                            총 열량 : ${product4.kcal}kcal<br>
                            단백질 : ${product4.protein}g<br>
                            탄수화물 : ${product4.carb}g<br>
                            지방 : ${product4.fat}g<br>
                            당 : ${product4.sugars}g<br>
                            나트륨 : ${product4.sodium}mmg<br>
                            가격 : ${product4.price}원<br>
                    </div>

                    <div class="diet">
                        <center><h4>금요일</h4></center>
                            ${product5.product_name}<br>
                            총 내용량 : ${product5.product_size}g<br>
                            총 열량 : ${product5.kcal}kcal<br>
                            단백질 : ${product5.protein}g<br>
                            탄수화물 : ${product5.carb}g<br>
                            지방 : ${product5.fat}g<br>
                            당 : ${product5.sugars}g<br>
                            나트륨 : ${product5.sodium}mmg<br>
                            가격 : ${product5.price}원<br>
                    </div>
                </div>
            <button class="diet-button" onclick="location.href='/'">홈으로 돌아가기</button>
        </div>
   </body>
</html>