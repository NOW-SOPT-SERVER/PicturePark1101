package com.example.demo.controller;

import com.example.demo.service.MemberService;
import com.example.demo.service.dto.MemberCreateDto;
import com.example.demo.service.dto.MemberFindDto;
import com.example.demo.service.dto.MemberListFindDto;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member") // 버전1의 api를 만든다.
public class MemberController {

  private final MemberService memberService;

  @PostMapping
  public ResponseEntity postMember(
      @RequestBody MemberCreateDto memberCreate
  ) {
    return ResponseEntity.created(URI.create(memberService.createMember(memberCreate))).build();
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
    return (ResponseEntity) ResponseEntity.noContent().build();
  }

  @GetMapping("")
  public ResponseEntity<MemberListFindDto> getAllMember() {
    return ResponseEntity.ok(memberService.findAllMember());
  }

}
