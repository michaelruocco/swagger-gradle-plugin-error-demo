package uk.co.mruoc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(tags = "Simple", description = "Simple resource")
public class SimpleEndpoint {

    @ApiOperation(value = "A response operation", response = SimpleRequest.class)
    @RequestMapping(path = "/simple-endpoint", method = RequestMethod.POST)
    public SimpleResponse response(@ApiParam SimpleRequest request) {
        return new SimpleResponse();
    }

}




