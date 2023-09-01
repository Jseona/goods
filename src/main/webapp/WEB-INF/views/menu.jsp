<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--부트스트랩의 효과는 class명이 결정한다. 임의로 class명 변경X--%>
<%--include를 이용해서 사용하는 페이지는 body안에 내용만 존재해야 함--%>
<%--navbar(메뉴바) navbar-expand-sm(크기) bg-dark navbar-dark(메뉴 배경색)--%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <%--container(작업영역) fluid(가로형)--%>
    <div class="container-fluid">
        <%--로고--%>
        <a class="navbar-brand" href="/">인싸</a> <%--img src 그림으로 로고--%>
        <%--반응형 웹처리, 스마트폰이나 태블릿처럼 세로형 화면에서 3선버튼을 이용해서 밑에 리스트모양으로 메뉴를 보여주겠다는 뜻--%>
        <%--data-bs-toggle 펼침효과, data-bs-target 클릭시 보일 클래스의 id--%>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">  <%--메뉴항목은 순서없는 목록(ul) navbar-nav(메뉴바의 메뉴구성)--%>
                <li class="nav-item dropdown">  <%--하나의 항목이 메뉴항목 1개, 관리자가 상품을 관리--%>
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">관리자</a>
                    <ul class="dropdown-menu">  <%--드롭다운의 서브메뉴 항목--%>
                        <li><a class="dropdown-item" href="/goods-insert">상품등록</a></li>
                        <li><a class="dropdown-item" href="/goods-list2">상품목록</a></li>
                    </ul> <%--#에 해당하는 페이지의 맵핑이름을 지정, 요구사항 파일이나 controller참고--%>
                </li>
                <li class="nav-item">  <%--이용자에게 제공할 목록--%>
                    <a class="nav-link" href="/goods-list">최신 상품</a>
                </li>
            </ul>
        </div>
    </div>
</nav>