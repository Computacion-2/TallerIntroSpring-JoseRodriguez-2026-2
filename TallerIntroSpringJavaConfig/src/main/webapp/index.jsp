<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión Discográfica - Inicio</title>
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
            <li><a href="${pageContext.request.contextPath}/track-create">Nueva Canción</a></li>
        </ul>
    </nav>

    <div class="container">
        <div class="page-header" style="flex-direction: column; align-items: flex-start; gap: 1rem;">
            <h1 class="page-title">Sistema de Gestión Discográfica de Artistas Musicales</h1>
            <p style="color: var(--text-secondary);">Plataforma desarrollada para el Taller 1 de Computación en Internet 2 (Spring Framework).</p>
        </div>

        <div class="card-grid">
            <div class="card">
                <div class="card-header">
                    <div class="card-title">👨‍🎤 Artistas</div>
                    <div class="card-subtitle">Consulta, crea y elimina artistas musicales registrados.</div>
                </div>
                <a href="${pageContext.request.contextPath}/artists" class="btn btn-primary">Ver Artistas</a>
            </div>

            <div class="card">
                <div class="card-header">
                    <div class="card-title">🔍 Buscar por Nombre</div>
                    <div class="card-subtitle">Encuentra un artista específico y explora toda su discografía.</div>
                </div>
                <a href="${pageContext.request.contextPath}/artist-search" class="btn btn-primary">Ir al Buscador</a>
            </div>

            <div class="card">
                <div class="card-header">
                    <div class="card-title">🎶 Canciones (Tracks)</div>
                    <div class="card-subtitle">Administra los temas registrados y sus artistas autores.</div>
                </div>
                <a href="${pageContext.request.contextPath}/tracks" class="btn btn-primary">Ver Canciones</a>
            </div>
        </div>
    </div>

    <footer class="footer">
        <p>Taller 1 - Spring Framework (Configuración XML / Annotations / JavaConfig)</p>
    </footer>
</body>
</html>
