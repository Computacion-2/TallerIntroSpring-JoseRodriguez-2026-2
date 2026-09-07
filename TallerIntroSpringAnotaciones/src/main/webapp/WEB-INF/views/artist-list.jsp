<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Artistas</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
    <nav class="navbar">
        <a href="${pageContext.request.contextPath}/" class="brand">🎵 Discografía App</a>
        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/artists" class="active">Artistas</a></li>
            <li><a href="${pageContext.request.contextPath}/artist-create">Nuevo Artista</a></li>
            <li><a href="${pageContext.request.contextPath}/artist-search">Buscar Artista</a></li>
            <li><a href="${pageContext.request.contextPath}/tracks">Canciones</a></li>
            <li><a href="${pageContext.request.contextPath}/track-create">Nueva Canción</a></li>
        </ul>
    </nav>

    <div class="container">
        <div class="page-header">
            <h1 class="page-title">Artistas Registrados</h1>
            <a href="${pageContext.request.contextPath}/artist-create" class="btn btn-primary">+ Crear Artista</a>
        </div>

        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Nacionalidad</th>
                        <th>Canciones Registradas</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="artist" items="${artists}">
                        <tr>
                            <td><code>${artist.id}</code></td>
                            <td><strong>${artist.name}</strong></td>
                            <td><span class="badge">${artist.nationality}</span></td>
                            <td>${artist.tracks.size()} temas</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/artist-search?name=${artist.name}" class="btn btn-secondary" style="padding: 0.25rem 0.5rem; font-size: 0.875rem;">Ver Detalle</a>
                                <a href="${pageContext.request.contextPath}/artist-delete?id=${artist.id}" class="btn btn-danger" style="padding: 0.25rem 0.5rem; font-size: 0.875rem;" onclick="return confirm('¿Eliminar artista ${artist.name}?')">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if var="isEmpty" test="${empty artists}">
                        <tr>
                            <td colspan="5" style="text-align: center; color: var(--text-secondary);">No hay artistas registrados aún.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
