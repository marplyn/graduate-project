package api.steps.loan_service;

import api.steps.common.CommonSteps;
import api.models.CommonRequest;
import api.models.delete_order.DeleteOrderPayload;
import api.models.post_order.PostOrderPayload;
import io.restassured.specification.RequestSpecification;

public class CommonLoanServiceSteps extends CommonSteps {

    protected RequestSpecification getTariffsRequestSpec(CommonRequest commonRequest) {
        final String path = "loan-service/getTariffs";

        return getRequestSpecBuilder(commonRequest, path).build();
    }

    protected RequestSpecification getPostOrderRequestSpec(CommonRequest commonRequest, PostOrderPayload payload) {
        final String path = "loan-service/order";

        return getRequestSpecBuilder(commonRequest, path, payload).build();
    }

    protected RequestSpecification getStatusOrderRequestSpec(CommonRequest commonRequest) {
        final String path = "loan-service/getStatusOrder";

        return getRequestSpecBuilder(commonRequest, path).build();
    }

    protected RequestSpecification getDeleteOrderRequestSpec(CommonRequest commonRequest, DeleteOrderPayload payload) {
        final String path = "loan-service/deleteOrder";

        return getRequestSpecBuilder(commonRequest, path, payload).build();
    }
}
