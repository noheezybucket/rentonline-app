<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 24/06/2024
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../components/taglib.jsp" %>
<html>
<head>
    <title>Rentline | Immeubles</title>
    <%@include file="../scripts/tailwind.jsp"%>
</head>
<body class="mx-auto w-9/12">
<%@include file="../components/header.jsp"%>

<main>
    <div class="flex justify-between items-center">
        <h2 class="text-xl font-bold">Immeubles</h2>
        <a
                href="admin-buildings-add.do"
                class="inline-block rounded bg-teal-600 px-4 py-2 font-medium text-white hover:bg-indigo-700"
        >
            Ajouter un immeuble
        </a>
    </div>

    <div class="overflow-x-auto">
        <table class="min-w-full divide-y-2 divide-gray-200 bg-white mt-5 border-collapse border text-center">
            <thead class=" bg-gray-200 rounded-xl">
            <tr>
                <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">ID</th>
                <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Nom de l'immeuble</th>
                <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Adresse</th>
                <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Equipements</th>
                <th class="px-4 py-2">Actions</th>
            </tr>
            </thead>

            <tbody class="divide-y divide-gray-200">
<c:forEach items="${buildModel.buildings}" var="building">

            <tr>
                <td class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">${ building.id }</td>
                <td class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">${ building.name }</td>
                <td class="whitespace-nowrap px-4 py-2 text-gray-700">${ building.address}</td>
                <td class="whitespace-nowrap px-4 py-2 text-gray-700">${ building.equipments }</td>
                <td class="whitespace-nowrap px-4 py-2">
                    <a href="admin-buildings-view.do?building_id=${building.id}" class="inline-block rounded bg-teal-600 px-4 py-2 font-medium text-white hover:bg-teal-700">
                        Détails
                    </a>
                    <a href="#" class="inline-block rounded bg-orange-600 px-4 py-2 font-medium text-white hover:bg-teal-700">
                        Modifier
                    </a>

                    <a href="#" class="inline-block rounded bg-red-600 px-4 py-2 font-medium text-white hover:bg-teal-700">
                        Supprimer
                    </a>
                </td>
            </tr>
</c:forEach>

            </tbody>
        </table>
    </div>
</main>
</body>
</html>
