<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Formulario de Agregacion de Estudiantes</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/ControladorEstudiante" class="boton-rojo-radio-inline"><i class="fa-solid fa-ban"></i><h6>Cancelar</h6></a>
            </div>
        </div>

        <div class="tabla">
            <form action="${pageContext.request.contextPath}/ControladorEstudiante?accion=insertar" method="post">
                <div class="mitad">
                    <div class="datos-rojo">
                        <label for="nombres">Nombres*</label>
                        <input type="text" id="nombres" name="nombres" class="block-100" required>
                    </div>

                    <div class="datos-rojo">
                        <label for="apellidos">Apellidos*</label>
                        <input type="text" id="apellidos" name="apellidos" class="block-100" required>
                    </div>
                </div>

                <fieldset>
                    <legend>Datos del Estudiante</legend>
                    <div>
                        <label for="edad">Edad</label>
                        <input type="number" id="edad" name="edad" class="block-100" min="11" required>
                    </div>

                    <div>
                        <label for="dni">DNI</label>
                        <input type="number" id="dni" name="dni" class="block-100" required>
                    </div>

                    <div>
                        <label for="genero">Genero</label>
                        <select id="genero" name="genero" class="block-100" required>
                            <option selected value=""></option>
                            <option value="M">Masculino</option>
                            <option value="F">Femenino</option>
                        </select>
                    </div>

                    <div>
                        <label for="celular">Nro Celular</label>
                        <input type="number" id="celular" name="celular" class="block-100" required>
                    </div>

                    <div>
                        <label for="direccion">Direccion</label>
                        <input type="text" id="direccion" name="direccion" class="block-100" required>
                    </div>

                    <div>
                        <label for="email">E-Mail</label>
                        <input type="email" id="email" name="email" class="block-100" required>
                    </div>

                    <div class="mitad">
                        <div>
                            <label for="fechaIngreso">Fecha Ingreso</label>
                            <input type="date" id="fechaIngreso" name="fechaIngreso" class="block-100" required>
                        </div>

                        <div>
                            <label for="imagenPerfil">Foto del Estudiante</label>
                            <input type="file" id="imagenPerfil" name="imagenPerfil" class="block-100" required>
                        </div>
                    </div>
                </fieldset>
    
                <div class="cont-registro">
                    <button type="submit" class="boton-transparente btn-crear"><i class="fa-solid fa-dragon"></i> Guardar Informacion</button>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../WEB-INF/templates/footer_user.jsp"/>