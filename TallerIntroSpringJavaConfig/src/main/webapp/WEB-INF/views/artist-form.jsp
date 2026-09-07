<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Crear Artista</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
    <nav class="navbar">
        <a href="${pageContext.request.contextPath}/" class="brand">🎵 Discografía App</a>
        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/artists">Artistas</a></li>
            <li><a href="${pageContext.request.contextPath}/artist-create" class="active">Nuevo Artista</a></li>
            <li><a href="${pageContext.request.contextPath}/artist-search">Buscar Artista</a></li>
            <li><a href="${pageContext.request.contextPath}/tracks">Canciones</a></li>
            <li><a href="${pageContext.request.contextPath}/track-create">Nueva Canción</a></li>
        </ul>
    </nav>

    <div class="container" style="max-width: 600px;">
        <div class="page-header">
            <h1 class="page-title">Registrar Nuevo Artista</h1>
        </div>

        <div class="card">
            <form action="${pageContext.request.contextPath}/artist-create" method="post">
                <div class="form-group">
                    <label for="name">Nombre del Artista / Banda:</label>
                    <input type="text" id="name" name="name" class="form-control" placeholder="Ej: Shakira, Queen..." required>
                </div>

                <div class="form-group">
                    <label for="nationality">Nacionalidad:</label>
                    <input type="text" id="nationality" name="nationality" class="form-control" placeholder="Ej: Colombia, Reino Unido..." required>
                </div>

                <div style="display: flex; gap: 1rem; justify-content: flex-end; margin-top: 1.5rem;">
                    <a href="${pageContext.request.contextPath}/artists" class="btn btn-secondary">Cancelar</a>
                    <button type="submit" class="btn btn-primary">Guardar Artista</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
