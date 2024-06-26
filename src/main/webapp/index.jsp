<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 24/06/2024
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./components/taglib.jsp" %>

<html>
  <head>
    <title>Rentline | Accueil</title>
    <%@include file="./scripts/tailwind.jsp"%>
  </head>
  <body class="mx-auto w-9/12">
  <%@include file="./components/header.jsp"%>

  <main>
    <h2 class="text-2xl">Bienvenue sur Rentline !</h2>

    <div class="grid grid-cols-3 gap-5 mt-4">

      <c:forEach items="${buildModel.buildings}" var="building">
        <div class="bg-gray-200 relative rounded-md">
          <span class="absolute top-1 right-1 text-xl font-bold bg-teal-600 rounded-md text-white px-2 py-1">${building.id}</span>
          <div>
            <img src="${building.image}"  class="h-[200px] w-full object-cover rounded-md" />
          </div>
          <div class="p-1">
            <h3 class="text-xl font-bold">${building.name}</h3>
            <h4>${building.address}</h4>
            <div class="mt-1">
              <a href="admin-buildings-view.do?building_id=${building.id}" class="inline-block rounded-md border border-teal-600 text-center hover:text-teal-600 hover:bg-transparent px-4 py-2 font-medium text-white bg-teal-600 w-full">
                Détails
              </a>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>


  </main>
  </body>
</html>
