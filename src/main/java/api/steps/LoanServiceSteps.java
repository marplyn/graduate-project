package api.steps;

import api.models.CommonRequest;
import api.models.delete_order.DeleteOrderPayload;
import api.models.get_status_order.GetStatusOrderRequest;
import api.models.post_order.PostOrderPayload;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

public class LoanServiceSteps extends CommonLoanServiceSteps {

    public Response getTariffs(CommonRequest request) {
        return given().spec(getTariffsRequestSpec(request))
                .get();
    }

    public Response postOrder(CommonRequest request, PostOrderPayload payload) {
        return given().spec(getPostOrderRequestSpec(request, payload))
                .post();
    }

    public Response getStatusOrder(GetStatusOrderRequest request) {
        return given().spec(getStatusOrderRequestSpec(request))
                .get();
    }

    public Response deleteOrder(CommonRequest request, DeleteOrderPayload payload) {
        return given().spec(getDeleteOrderRequestSpec(request, payload))
                .delete();
    }
}
