package api.models;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "error")
public class Error {
    private String code;
    private String message;
}
