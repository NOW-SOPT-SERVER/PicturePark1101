package com.example.demo.controller;

import com.example.demo.common.dto.SuccessMessage;
import com.example.demo.common.dto.SuccessStatusResponse;
import com.example.demo.service.MemberService;
import com.example.demo.service.dto.member.RegenerateAccessTokenRequestDto;
import com.example.demo.service.dto.member.UserJoinResponse;
import com.example.demo.service.dto.member.MemberCreateDto;
import com.example.demo.service.dto.member.MemberFindDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members") // 버전1의 api를 만든다.
public class MemberController {

  private final MemberService memberService;

  @PostMapping
  public ResponseEntity<SuccessStatusResponse> postMember(
      @RequestBody MemberCreateDto memberCreate
  ) {
    UserJoinResponse userJoinResponse = memberService.createMember(memberCreate);
    return ResponseEntity.status(HttpStatus.CREATED)
        .header("Location", userJoinResponse.userId())
        .body(SuccessStatusResponse.of (SuccessMessage.MEMBER_SING_UP_SUCCESS, userJoinResponse));
  }

  @PostMapping("/regenerate-token")
  public ResponseEntity<SuccessStatusResponse> regenerateToken(
      @RequestBody RegenerateAccessTokenRequestDto regenerateAccessTokenRequestDto
  ) {
    System.out.println("------service-----");

    return ResponseEntity.ok()
        .body(SuccessStatusResponse.of(
            SuccessMessage.ACCESS_TOKEN_REGENERATE_SUCCESS,
            memberService.getNewAccessToken(regenerateAccessTokenRequestDto)));
  }

  @GetMapping("/{memberId}")
  public ResponseEntity<MemberFindDto> getMemberById(
      @PathVariable Long memberId
  ) {
    return ResponseEntity.ok(memberService.findMemberById2(memberId));
  }

  @DeleteMapping("/{memberId}")
  public ResponseEntity deleteMember(
      @PathVariable Long memberId
  ) {
    memberService.deleteMemberById(memberId);
    return ResponseEntity.noContent().build();
  }
}
