<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Formulario de Agregacion de Profesores</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/ControladorProfesores" class="boton-rojo-radio-inline"><i class="fa-solid fa-ban"></i><h6>Cancelar</h6></a>
            </div>
        </div>

        <div class="tabla">
            <form action="${pageContext.request.contextPath}/ControladorProfesor?accion=insertar" method="post">
                <div class="tercios-221">
                    <div>
                        <label for="nombres">Nombres</label>
                        <input type="text" id="nombres" name="nombres" class="block-100" required>
                    </div>
    
                    <div>
                        <label for="apellidos">Apellidos</label>
                        <input type="text" id="apellidos" name="apellidos" class="block-100" required>
                    </div>
    
                    <div>
                        <label for="dni">Dni</label>
                        <input type="number" id="dni" name="dni" class="block-100" required>
                    </div>
                </div>

                <div class="tercios-iguales">
                    <div>
                        <label for="edad">Edad</label>
                        <input type="number" id="edad" name="edad" class="block-100" required>
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
                </div>

                <div>
                    <label for="direccion">Direccion</label>
                    <input type="text" id="direccion" name="direccion" class="block-100" required>
                </div>
    
                <div>
                    <label for="email">Email</label>
                    <input type="text" id="email" name="email" class="block-100" required>
                </div>
    
                <div>
                    <label for="sueldo">Sueldo</label>
                    <input type="number" id="sueldo" name="sueldo" class="block-100" required>
                </div>

                <div>
                    <label for="imagen">Imagen</label>
                    <input type="file" id="imagen" name="imagen" class="block-100" required>
                </div>
    
                <div class="cont-registro">
                    <button type="submit" class="boton-transparente btn-crear"><i class="fa-solid fa-dragon"></i> Guardar Informacion</button>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="../WEB-INF/templates/footer_user.jsp"/>