package io.international.controller;

import io.international.model.InternationalModel;
import io.international.service.InternationalService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Davis on 17/1/6.
 */
@RestController
public class InternationalController {
  @Autowired
  private InternationalService service;

  @ApiOperation("set default currency")
  @PutMapping("/internation")
  public InternationalModel setDefaultCurrency(@RequestParam
                                               @ApiParam(value = "currency code", required = true)
                                                   String currencyCode) {
    return service.setDefaultCurrency(currencyCode);
  }

  @ApiOperation("add support currency")
  @PutMapping("/internations")
  public InternationalModel addSupportCurrency(@RequestParam
                                               @ApiParam(value = "currency code", required = true)
                                                   String currencyCode){
    return service.addSupportCurrency(currencyCode);
  }
}
