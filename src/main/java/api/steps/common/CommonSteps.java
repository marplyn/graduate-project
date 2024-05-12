package api.steps.common;

import api.models.ErrorResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps extends CommonBackendSteps {

    @Step("Проверить, что статус код ответа равен 200")
    public void responseShouldIndicateThatRequestWasSuccessful(Response response) {
        assertThat(response.getStatusCode()).isEqualTo(200);
    }

    @Step("Проверить, что статус код ответа равен 400")
    public void responseShouldIndicateThatRequestWasBadRequest(Response response) {
        assertThat(response.getStatusCode()).isEqualTo(400);
    }

    @Step("Проверить, что сообщение об ошибке соответсвует ожидаемому")
    public void responseShouldHaveErrorCodeAndMessage(Response response, String errorCode, String errorMessage) {
        assertThat(response.getBody().as(ErrorResponse.class)).isNotNull();
        assertThat(response.getBody().as(ErrorResponse.class).getCode()).isEqualTo(errorCode);
        assertThat(response.getBody().as(ErrorResponse.class).getMessage()).isEqualTo(errorMessage);
    }
}
