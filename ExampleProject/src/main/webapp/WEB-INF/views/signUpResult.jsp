<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>

	<%

        String memberId = request.getParameter("memberId");

        String[] memberPw = request.getParameterValues("memberPw");
        
        String memberName = request.getParameter("memberName");
        
        String memberEmail = request.getParameter("memberEmail");
        
        String[] hobby = request.getParameterValues("hobby");


    %>

	<% if( !memberPw[0].equals(memberPw[1])) { %>
	
		<h3>비밀번호가 일치하지 않습니다</h3>
	
	<%} else { %>
		
		<ul>
			<li>아이디 : <%= memberId %></li>
			
			<li>비밀번호 : <%= memberPw[0] %></li>
			
			<li>이름 : <%= memberName %></li>
			
			<li>이메일 : <%= memberEmail %></li>
			
			<li>취미 :
			 	<% for(String h : hobby) { %>
			 		<%= h %>
			 	<% } %>
			</li>
		</ul>
	
		<h3><%=memberName %> 의 회원가입이 완료되었습니다. </h3>
	
	
	
	<% } %>

    
</body>
</html>