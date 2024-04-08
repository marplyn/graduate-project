package api.steps;

import api.enums.ErrorCode;
import api.enums.OrderStatus;
import api.models.CreateOrderRequest;
import api.models.DeleteOrderRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LoanServiceSteps {
    private Response response;

    // httpStatus check

    public LoanServiceSteps responseStatusShouldBeEqualTo(int httpStatus) {
        Assertions.assertEquals(httpStatus, response.getStatusCode());
        return this;
    }

    // GET Tariffs
    public LoanServiceSteps getTariffs() {
        response = given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get("loan-service/getTariffs")
                .then()
                .and()
                .extract().response();
        response.prettyPrint();
        return this;
    }

    public void getTariffsShouldBeSuccessful() {
        response.then().assertThat().body("data.tariffs[0]", notNullValue());
    }

    // POST CreateOrder

    public LoanServiceSteps postCreateOrder(CreateOrderRequest createOrderRequest) {
        response = given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(createOrderRequest)
                .post("loan-service/order")
                .then()
                .and()
                .extract().response();
        response.prettyPrint();
        return this;
    }

    public void postCreateOrderShouldBeSuccessful() {
        response.then().assertThat().body("data.orderId", notNullValue());
    }

    public String orderIdFromResponse() {
        return response.path("data.orderId");
    }

    public void postCreateOrderShouldHaveError() {
        response.then().assertThat().body("error.code", anyOf(
                is(ErrorCode.TARIFF_NOT_FOUND.toString()),
                is(ErrorCode.TRY_LATER.toString()),
                is(ErrorCode.LOAN_CONSIDERATION.toString()),
                is(ErrorCode.LOAN_ALREADY_APPROVED.toString())));
    }

    // GET StatusOrder

    public LoanServiceSteps getStatusOrder(String orderId) {
        response = given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get(String.format("loan-service/getStatusOrder?orderId=%s", orderId))
                .then()
                .and()
                .extract().response();
        response.prettyPrint();
        return this;
    }

    public void getStatusOrderShouldBeSuccessful() {
        response.then().assertThat().body("data.orderStatus", anyOf(
                is(OrderStatus.APPROVED.toString()),
                is(OrderStatus.IN_PROGRESS.toString()),
                is(OrderStatus.REFUSED.toString())));
    }

    public void getStatusOrderShouldBeFailed() {
        response.then().assertThat().body("error.code",
                is(ErrorCode.ORDER_NOT_FOUND.toString()));
    }

    // DELETE Order
    public LoanServiceSteps deleteOrder(DeleteOrderRequest deleteOrderRequest) {
        response = given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(deleteOrderRequest)
                .delete("loan-service/deleteOrder")
                .then()
                .and()
                .extract().response();
        response.prettyPrint();
        return this;
    }

    public void deleteOrderShouldBeFailed() {
        response.then().assertThat().body("error.code", anyOf(
                is(ErrorCode.ORDER_IMPOSSIBLE_TO_DELETE.toString()),
                is(ErrorCode.ORDER_NOT_FOUND.toString())));
    }
}
