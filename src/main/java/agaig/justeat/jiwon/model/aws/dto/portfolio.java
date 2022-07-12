package agaig.justeat.jiwon.model.aws.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class portfolio {
    private Long idx;
    private String start_data;
    private String deadline;
    private String header;
    private String description;
    private String image_path;

}
