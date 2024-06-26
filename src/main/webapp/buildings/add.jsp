<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 24/06/2024
  Time: 3:23 PM
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
                href="admin-buildings-list.do"
                class="inline-block rounded bg-teal-600 px-4 py-2 font-medium text-white hover:bg-indigo-700"
        >
            Liste des immeubles
        </a>
    </div>

    <div>
        <form action="admin-buildings-save.do" method="post" class="space-y-5 mt-4">
                <input type="text" id="name" name="name" class="border block w-full rounded-md p-2" placeholder="Nom de l'immeuble"/>

                <input type="text" id="address" name="address" class="border block w-full rounded-md p-2" placeholder="Adresse de l'immeuble"/>

                <input type="text" id="description" name="description" class="border block w-full rounded-md p-2" placeholder="Description"/>

                <input type="text" id="equipements" name="equipments" class="border block w-full rounded-md p-2" placeholder="equipement 1, equipement 2 ..."/>

                <input type="text" id="image" name="image" class="border block w-full rounded-md p-2" placeholder="https://url.com"/>

            <div class="flex justify-center gap-10">
                <input type="submit" id="submit" name="submit" value="Ajouter un nouvel immeuble" class="block bg-teal-600 rounded-md px-5 py-2.5 font-medium text-white shadow w-full"/>
                <input type="reset" id="cancel" name="cancel" value="Vider le formulaire" class="block bg-red-600 rounded-md px-5 py-2.5 font-medium text-white shadow w-full" />
            </div>
        </form>
    </div>
</body>
</html>
