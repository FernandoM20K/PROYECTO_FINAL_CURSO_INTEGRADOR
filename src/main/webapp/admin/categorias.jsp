<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../WEB-INF/templates/header_user.jsp"/>
<jsp:include page="../WEB-INF/templates/dashboard.jsp"/>

<div class="contenedord">
    <div class="titulo">
        <h4>Lista de Categorias de Productos</h4>
    </div>
    <div class="informacion notas">
        <div class="funciones-profesor">
            <div class="mensaje-export">
                <a href="${pageContext.request.contextPath}/agregarCategoria.jsp" class="boton-verde-radio-inline"><i class="fa-solid fa-user-plus"></i><h6>Agregar Categoria</h6></a>
            </div>
            
            <h6>Total de Registros: ${totalCategorias}</h6>
        </div>

        <div class="tabla t-profesores">
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nombre Categoria</th>
                    </tr>
                </thead>
                <tbody>
                    <!--INICIO ITERACION DE CADA ELEMENTO DE LA LISTA DE CATEGORIAS-->
                    <c:forEach var="categoria" items="${categorias}">
                        <tr>
                            <td>${categoria.idCategoria}</td>
                            <td>${categoria.nombreCategoria}</td>
                        </tr>
                    </c:forEach><!--FIN ITERACION DE CADA ELEMENTO DE LA LISTA DE CATEGORIAS-->
                </tbody>
            </table>
        </div>
    </div>
</div>

<jsp:include page="../WEB-INF/templates/footer_user.jsp"/>