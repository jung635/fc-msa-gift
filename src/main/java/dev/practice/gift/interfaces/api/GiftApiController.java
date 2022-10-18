package dev.practice.gift.interfaces.api;

import dev.practice.gift.application.GiftFacade;
import dev.practice.gift.common.response.CommonResponse;
import dev.practice.gift.domain.gift.GiftInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/gifts")
public class GiftApiController {
    private final GiftFacade giftFacade;
    private final GiftDtoMapper giftDtoMapper;

    @PostMapping("/register")
    public CommonResponse registerOrder(@RequestBody @Valid GiftDto.RegisterGiftReq request) {
        GiftInfo giftInfo = giftFacade.registerGiftOrder(giftDtoMapper.of(request));
        return CommonResponse.success(new GiftDto.RegisterGiftRes(giftInfo));
    }
}
