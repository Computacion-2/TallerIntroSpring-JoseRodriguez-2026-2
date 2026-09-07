<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Crear Canción</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
    <nav class="navbar">
        <a href="${pageContext.request.contextPath}/" class="brand">🎵 Discografía App</a>
        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/artists">Artistas</a></li>
            <li><a href="${pageContext.request.contextPath}/artist-create">Nuevo Artista</a></li>
            <li><a href="${pageContext.request.contextPath}/artist-search">Buscar Artista</a></li>
            <li><a href="${pageContext.request.contextPath}/tracks">Canciones</a></li>
            <li><a href="${pageContext.request.contextPath}/track-create" class="active">Nueva Canción</a></li>
        </ul>
    </nav>

    <div class="container" style="max-width: 650px;">
        <div class="page-header">
            <h1 class="page-title">Registrar Nueva Canción (Track)</h1>
        </div>

        <div class="card">
            <form action="${pageContext.request.contextPath}/track-create" method="post">
                <div class="form-group">
                    <label for="title">Título de la Canción:</label>
                    <input type="text" id="title" name="title" class="form-control" placeholder="Ej: Bohemian Rhapsody, Thriller..." required>
                </div>

                <div class="form-group">
                    <label for="genre">Género Musical:</label>
                    <input type="text" id="genre" name="genre" class="form-control" placeholder="Ej: Rock, Pop, Reggaeton, Jazz..." required>
                </div>

                <div class="form-group">
                    <label for="albumTitle">Álbum:</label>
                    <input type="text" id="albumTitle" name="albumTitle" class="form-control" placeholder="Nombre del Álbum..." required>
                </div>

                <div class="form-group">
                    <label for="duration">Duración (en segundos):</label>
                    <input type="number" id="duration" name="duration" class="form-control" placeholder="Ej: 218 (para 03:38)" min="1" required>
                </div>

                <div class="form-group">
                    <label for="artistIds">Artistas Autores (Mantenga presionado Ctrl/Cmd para seleccionar varios):</label>
                    <select id="artistIds" name="artistIds" class="form-control" multiple required>
                        <c:forEach var="artist" items="${artists}">
                            <option value="${artist.id}">${artist.name} (${artist.nationality})</option>
                        </c:forEach>
                    </select>
                </div>

                <div style="display: flex; gap: 1rem; justify-content: flex-end; margin-top: 1.5rem;">
                    <a href="${pageContext.request.contextPath}/tracks" class="btn btn-secondary">Cancelar</a>
                    <button type="submit" class="btn btn-primary">Guardar Canción</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
