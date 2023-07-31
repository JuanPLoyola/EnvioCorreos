<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <title>Formulario de Correo</title>
  <!-- Agregar los enlaces a los archivos CSS de Bootstrap -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card">
        <div class="card-header">
          <h2 class="text-center">Formulario de Correo</h2>
        </div>
        <div class="card-body">
          <form action="<%=request.getContextPath()%>/hello-servlet?p=Enviar" method="post">
            <div class="form-group">
              <label for="correo">Correo:</label>
              <input type="email" class="form-control" id="correo" name="correoDestino" required>
            </div>

            <div class="form-group">
              <label for="asunto">Asunto:</label>
              <input type="text" class="form-control" id="asunto" name="asunto" required>
            </div>

            <div class="form-group">
              <label for="contenido">Contenido:</label>
              <textarea class="form-control" id="contenido" name="contenido" rows="4" required></textarea>
            </div>

            <div class="text-center">
              <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Agregar el enlace al archivo JavaScript de Bootstrap (Opcional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

