<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 24/06/2024
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../components/taglib.jsp" %>
<html>
<head>
    <title>Rentline | Ajout d'immeuble</title>
    <%@ include file="../scripts/tailwind.jsp" %>
</head>
<body class="mx-auto w-9/12">
<%@include file="../components/header.jsp"%>
<div class="flex justify-between items-center">
    <h2 class="text-xl font-bold">${building.name}</h2>
    <a
            href="list.building"
            class="inline-block rounded bg-teal-600 px-4 py-2 font-medium text-white hover:bg-indigo-700"
    >
        Liste des immeubles
    </a>
</div>

<div class="my-4">

    <img src="${building.image}"  class="h-[250px] w-full object-cover rounded-md" />
</div>

<div>
    <form action="" method="post" class="space-y-5 ">
        <input
                type="text"
                id="address"
                name="address"
                class="border block w-full rounded-md p-2"
                placeholder="Adresse de l'immeuble"
                value="${building.address}"
                readonly
        />

        <input
                type="text"
                id="description"
                name="description"
                class="border block w-full rounded-md p-2"
                placeholder="Description"
                value="${building.description}"
                readonly
        />

        <input
                type="text"
                id="equipements"
                name="equipments"
                class="border block w-full rounded-md p-2"
                placeholder="equipement 1, equipement 2 ..."
                value="${building.equipments}"
                readonly
        />
    </form>
</div>
</body>
</html>

