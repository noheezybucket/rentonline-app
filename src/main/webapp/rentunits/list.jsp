<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 26/06/2024
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../components/taglib.jsp" %>
<html>
<head>
    <title>Rentline | Unités de location</title>
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
                <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Nombre de pièces</th>
                <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Surface</th>
                <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Loyer</th>
                <th class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">Immeuble</th>
                <th class="px-4 py-2">Actions</th>
            </tr>
            </thead>

            <tbody class="divide-y divide-gray-200">
            <c:forEach items="${rentModel.rentUnits}" var="rentunit">

                <tr>
                    <td class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">${ rentunit.id }</td>
                    <td class="whitespace-nowrap px-4 py-2 font-medium text-gray-900">${ rentunit.pieces  } pièces</td>
                    <td class="whitespace-nowrap px-4 py-2 text-gray-700">${ rentunit.surface} m2</td>
                    <td class="whitespace-nowrap px-4 py-2 text-gray-700">${ rentunit.price } XOF/mois</td>
                    <td class="whitespace-nowrap px-4 py-2 text-gray-700"> Immeuble N ${ rentunit.building_id} </td>
                    <td class="whitespace-nowrap px-4 py-2">
                        <a href="admin-buildings-view.do?building_id=${rentunit.id}" class="inline-block rounded bg-teal-600 px-4 py-2 font-medium text-white hover:bg-teal-700">
                            Détails
                        </a>
                        <a href="admin-buildings-edit.do?building_id=${rentunit.id}" class="inline-block rounded bg-orange-600 px-4 py-2 font-medium text-white hover:bg-teal-700">
                            Modifier
                        </a>

                        <a href="admin-buildings-delete.do?building_id=${rentunit.id}" class="inline-block rounded bg-red-600 px-4 py-2 font-medium text-white hover:bg-teal-700">
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
