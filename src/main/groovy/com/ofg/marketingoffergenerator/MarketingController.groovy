package com.ofg.marketingoffergenerator

import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.constraints.NotNull

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.PUT

@Slf4j
@RestController
@RequestMapping('/api/marketing')
@TypeChecked
@Api(value = "marketing", description = "Collects loan application decisions and generates marketing offers")
class MarketingController {

    @RequestMapping(
            value = '{loanApplicationId}',
            method = PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Collects loan application decision",
            notes = "Collects loan application decision")
    public void generateOfferForLoanApplicationDecision(@PathVariable @NotNull long loanApplicationId) {

    }

    @RequestMapping(
            value = '{name}',
            method = GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns marketing offer",
            notes = "Returns marketing offer")
    public String getMarketingOffer(@PathVariable @NotNull String name) {

    }

}
