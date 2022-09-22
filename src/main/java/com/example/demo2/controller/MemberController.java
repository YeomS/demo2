package com.example.demo2.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo2.dto.MemberDTO;
import com.example.demo2.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // Simple Logging Facade for Java

public class MemberController {

	@Autowired
	private MemberService memberService;
	
	// 컨트롤러
	
	//회원조회
	@RequestMapping("/member/list")
	public ModelAndView memberList() {
		System.out.println("========================== MemberController(/member/list) ==================================");
		ModelAndView mv=new ModelAndView("/member/list");
		List<MemberDTO> list=memberService.findMemberList();
		mv.addObject("list", list);
		return mv;
	}
	//회원상세정보
	@RequestMapping("/member/detail")
	public ModelAndView memberDetail(
	@RequestParam String id
	) {
		System.out.println("========================== MemberController(/member/detail) ==================================");
	ModelAndView mv=new ModelAndView("/member/detail");
	MemberDTO member=memberService.findMemberDetail(id);
	mv.addObject("member", member);
	return mv;
	}
	
	//회원가입
	@RequestMapping("/member/registerForm")
	public ModelAndView registerForm() {
		System.out.println("========================== MemberController(/member/registerForm) ==================================");
	ModelAndView mv=new ModelAndView("/member/registerForm");
	return mv;
	}
	@RequestMapping("/member/register")
	public ModelAndView registerMember(
	MemberDTO memberDTO, HttpServletRequest request
	) {
		System.out.println("========================== MemberController(/member/register) ==================================");
	memberService.registerMember(memberDTO);
	ModelAndView mv=new ModelAndView("redirect:" + request.getContextPath() + "/member/list");
	return mv;
	}
	
	
	//회원삭제
	@RequestMapping("/member/remove")
	public ModelAndView removeMember(
	@RequestParam String id, HttpServletRequest request
	) {
		System.out.println("========================== MemberController(/member/remove) ==================================");

	memberService.removeMember(id);
	ModelAndView mv=new ModelAndView("redirect:" + request.getContextPath() + "/member/list");
	return mv;
	}

}
