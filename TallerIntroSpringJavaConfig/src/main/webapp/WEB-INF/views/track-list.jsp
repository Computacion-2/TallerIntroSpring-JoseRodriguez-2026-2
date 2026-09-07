<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Canciones</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
    <nav class="navbar">
        <a href="${pageContext.request.contextPath}/" class="brand">🎵 Discografía App</a>
        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/artists">Artistas</a></li>
            <li><a href="${pageContext.request.contextPath}/artist-create">Nuevo Artista</a></li>
            <li><a href="${pageContext.request.contextPath}/artist-search">Buscar Artista</a></li>
            <li><a href="${pageContext.request.contextPath}/tracks" class="active">Canciones</a></li>
            <li><a href="${pageContext.request.contextPath}/track-create">Nueva Canción</a></li>
        </ul>
    </nav>

    <div class="container">
        <div class="page-header">
            <h1 class="page-title">Canciones Registradas (${tracks.size()})</h1>
            <a href="${pageContext.request.contextPath}/track-create" class="btn btn-primary">+ Crear Canción</a>
        </div>

        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Título</th>
                        <th>Género</th>
                        <th>Álbum</th>
                        <th>Duración</th>
                        <th>Artistas Autores</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="track" items="${tracks}">
                        <tr>
                            <td><code>${track.id}</code></td>
                            <td><strong>${track.title}</strong></td>
                            <td><span class="badge">${track.genre}</span></td>
                            <td>${track.albumTitle}</td>
                            <td>${track.formattedDuration}</td>
                            <td>
                                <c:forEach var="artist" items="${track.artists}" varStatus="status">
                                    <a href="${pageContext.request.contextPath}/artist-search?name=${artist.name}" style="color: var(--accent); text-decoration: none;">${artist.name}</a><c:if test="${!status.last}">, </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/track-delete?id=${track.id}" class="btn btn-danger" style="padding: 0.25rem 0.5rem; font-size: 0.875rem;" onclick="return confirm('¿Eliminar la canción ${track.title}?')">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty tracks}">
                        <tr>
                            <td colspan="7" style="text-align: center; color: var(--text-secondary);">No hay canciones registradas aún.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
