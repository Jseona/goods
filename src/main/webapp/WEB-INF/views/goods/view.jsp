<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang='en'>
<head> <%--부트스트랩 스크립트와 CSS, JQuery를 연동--%>
    <title>인싸쇼핑몰</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%--메뉴 구성--%>
<%--같은 위치에 있으면 파일명만, 다른 위치에 있으면 경로/파일명 으로 지정--%>
<%--..(현재폴더를 벗어나서)/파일명,
    ../head/파일명(현재폴더에서 벗어나서 head폴더로 들어가서 사용하겠다는 뜻--%>
<jsp:include page="../menu.jsp"/>

<%--본문 내용--%>
<div class="row">
    <div class="col-sm-4"></div> <%--여백--%>
    <%--mav.addObject("list", list);--%>
        <div class="col-sm-4">
            <div class="card">
                <div class="card-header">${list.ggoods}
                    <span class="badge bg-secondary">신상품</span>
                </div>
                <div class="card-body">
                    <img src="/images/${list.gimgfile}" class="img-thumbnail"
                         alt="이미지 준비중">
                </div>
                <div class="card-footer">
                    <p>${list.gcontent}</p>
                    <p>가격 : ${list.gprice}원 </p>
                    <button type="button" class="btn btn-primary">구매하기</button>
                    <button type="button" class="btn btn-secondary">장바구니</button>
                </div>
            </div>
        </div>
    <div class="col-sm-4"></div> <%--여백--%>

</div>
</body>
</html>