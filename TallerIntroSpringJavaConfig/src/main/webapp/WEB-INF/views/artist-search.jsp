<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Buscar Artista</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
    <nav class="navbar">
        <a href="${pageContext.request.contextPath}/" class="brand">🎵 Discografía App</a>
        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/artists">Artistas</a></li>
            <li><a href="${pageContext.request.contextPath}/artist-create">Nuevo Artista</a></li>
            <li><a href="${pageContext.request.contextPath}/artist-search" class="active">Buscar Artista</a></li>
            <li><a href="${pageContext.request.contextPath}/tracks">Canciones</a></li>
            <li><a href="${pageContext.request.contextPath}/track-create">Nueva Canción</a></li>
        </ul>
    </nav>

    <div class="container">
        <div class="page-header">
            <h1 class="page-title">Buscar Artista y su Discografía</h1>
        </div>

        <div class="card" style="margin-bottom: 2rem;">
            <form action="${pageContext.request.contextPath}/artist-search" method="get" style="display: flex; gap: 1rem; align-items: flex-end;">
                <div class="form-group" style="flex: 1; margin-bottom: 0;">
                    <label for="name">Nombre del Artista:</label>
                    <input type="text" id="name" name="name" class="form-control" placeholder="Ingrese el nombre a buscar (ej: Shakira)..." value="${param.name}" required>
                </div>
                <button type="submit" class="btn btn-primary">Buscar</button>
            </form>
        </div>

        <c:if test="${found == true}">
            <div class="card" style="margin-bottom: 1.5rem;">
                <div class="card-header" style="display: flex; justify-content: space-between; align-items: center;">
                    <div>
                        <h2 class="card-title" style="font-size: 1.5rem;">${artist.name}</h2>
                        <span class="badge" style="font-size: 0.875rem;">Nacionalidad: ${artist.nationality}</span>
                    </div>
                    <div>
                        <a href="${pageContext.request.contextPath}/artist-delete?id=${artist.id}" class="btn btn-danger" onclick="return confirm('¿Eliminar artista ${artist.name}?')">Eliminar Artista</a>
                    </div>
                </div>
            </div>

            <h3 style="margin-bottom: 1rem;">Tracks Asociados (${artist.tracks.size()})</h3>
            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>Título</th>
                            <th>Género</th>
                            <th>Álbum</th>
                            <th>Duración</th>
                            <th>Co-autores</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="track" items="${artist.tracks}">
                            <tr>
                                <td><strong>${track.title}</strong></td>
                                <td><span class="badge">${track.genre}</span></td>
                                <td>${track.albumTitle}</td>
                                <td>${track.formattedDuration}</td>
                                <td>
                                    <c:forEach var="aut" items="${track.artists}" varStatus="status">
                                        ${aut.name}<c:if test="${!status.last}">, </c:if>
                                    </c:forEach>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty artist.tracks}">
                            <tr>
                                <td colspan="5" style="text-align: center; color: var(--text-secondary);">Este artista no tiene canciones registradas aún.</td>
                            </tr>
                        </c:if>
                    </tbody>
                </table>
            </div>
        </c:if>

        <c:if test="${found == false}">
            <div class="card" style="text-align: center; border-color: var(--danger);">
                <p style="color: var(--danger); font-weight: 600;">No se encontró ningún artista con el nombre "${searchQuery}".</p>
            </div>
        </c:if>
    </div>
</body>
</html>
