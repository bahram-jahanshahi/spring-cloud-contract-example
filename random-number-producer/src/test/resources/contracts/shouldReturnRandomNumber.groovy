package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return random number"
    request{
        method GET()
        url("/random/generate") {
            queryParameters {
                // parameter("number", "2")
            }
        }
    }
    response {
        body(wow: 123)
        status 200
        headers {
            contentType applicationJson()
        }
    }
}
