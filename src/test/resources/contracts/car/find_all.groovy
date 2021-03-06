import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return all cars"

    request {
        url "/car"
        method GET()
    }

    response {
        status 200
        headers {
            contentType applicationJson()
        }
        body ([
                "cars": [
                        "make": value(anyNonBlankString()),
                        "fuel": regex("GASOLINE|DIESEL")
                ]
        ])
    }
}