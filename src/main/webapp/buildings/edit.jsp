<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 26/06/2024
  Time: 2:58 AM
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
    <h2 class="text-xl font-bold">Ajouter un immeuble</h2>
    <a
            href="list.building"
            class="inline-block rounded bg-teal-600 px-4 py-2 font-medium text-white hover:bg-indigo-700"
    >
        Liste des immeubles
    </a>
</div>

<div>
    <form action="edit-process.building" method="post" class="space-y-5 mt-4">
        <input
                type="text"
                id="id"
                name="id"
                class="border block w-full rounded-md p-2"
                value="${building.id}"
                readonly
        />

        <input type="text"
               id="name"
               name="name"
               class="border block w-full rounded-md p-2"
               placeholder="Nom de l'immeuble" value="${building.name}"
        />

        <input type="text"
               id="address"
               name="address"
               class="border block w-full rounded-md p-2"
               placeholder="Adresse de l'immeuble"
               value="${building.address}"
        />

        <input type="text" id="description" name="description" class="border block w-full rounded-md p-2" placeholder="Description"

               value="${building.description}"
        />

        <input type="text" id="equipements" name="equipments" class="border block w-full rounded-md p-2" placeholder="equipement 1, equipement 2 ..."

               value="${building.equipments}"
        />

        <input type="text" id="image" name="image" class="border block w-full rounded-md p-2" placeholder="https://url.com"

               value="${building.image}"
        />

        <div class="flex justify-center gap-10">
            <input type="submit" id="submit" name="submit" value="Enregistrer les modifications" class="block bg-teal-600 rounded-md px-5 py-2.5 font-medium text-white shadow w-full"/>
        </div>
    </form>
</div>
</body>
</html>
