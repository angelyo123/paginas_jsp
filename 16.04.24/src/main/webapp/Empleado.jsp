<!-- Referenciar la libreria CORE que se encuentra en JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empleado</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link https://cdn.datatables.net/2.0.3/css/dataTables.bootstrap5.css>
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet">
<style>
.modal-header {
	color: #fff;
	background: #428bca;
	display: flex;
	justify-content: center;
}

.help-block {
	color: red;
}

.form-group.has-error .form-control-label {
	color: red;
}

.form-group.has-error .form-control {
	border: 1px solid red;
	box-shadow: 0 0 0 0.2rem rgba(250, 16, 0, 0.18);
}
.form-group.has-error .form-select {
	border: 1px solid red;
	box-shadow: 0 0 0 0.2rem rgba(250, 16, 0, 0.18);
}
</style>
</head>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Navbar</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNavDarkDropdown"
			aria-controls="navbarNavDarkDropdown" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
					<ul class="dropdown-menu dropdown-menu-dark">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>

<body>
	<div class="container">
		<h4 class="text-center mt-3">LISTADO DE EMPLEADOS</h4>

		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#modalEmpleado">Nuevo Empleado</button>








		<table id="tableEmpleados" class="table table-striped"
			style="width: 100%">
			<thead>
				<tr>
					<th>Codigo</th>
					<th>Nombre</th>
					<th>Paterno</th>
					<th>Materno</th>
					<th>Sexo</th>
					<th>Hijos</th>
					<th></th>
				</tr>
			</thead>
			
			<tbody>
			</tbody>
			
		</table>
		
		
		
		
		
		
		
		
		
		<!-- Modal -->
		<div class="modal fade" id="modalEmpleado" data-bs-backdrop="static"
			data-bs-keyboard="false" tabindex="-1"
			aria-labelledby="staticBackdropLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="staticBackdropLabel">Empleado</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>

					</div>
					<div class="modal-body">
						<form id="formEmpleado" method="post" action="ServletEmpleado?accion=grabar">
						
						
						<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">Código</label>
								<input type="text" class="form-control" name="codigo" id="id-codigo" value="0" readonly>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">Nombre</label>
								<input type="text" class="form-control" name="nombre" id="id-nombre">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">Paterno</label>
								<input type="text" class="form-control" name="paterno" id="id-paterno">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">Materno</label>
								<input type="text" class="form-control" name="materno" id="id-materno">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">Hijos</label>
								<input type="text" class="form-control" name="hijos" id="id-hijos">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">Sueldo</label>
								<input type="text" class="form-control" name="sueldo" id="id-sueldo">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">Sexo</label>
								<select class="form-select" name="sexo" id="id-sexo">
									<option value=" " selected>[Seleccione Sexo]</option>
									<option value="Femenino">Femenino</option>
									<option value="Masculino">Masculino</option>
									<option value="Otros">Otros</option>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">Tipo empleado</label>
								<select class="form-select" name="tipo" id="id-tipo">
									<option value=" " selected>[Seleccione tipo de empleado]</option>
									<option value="1">Administrador</option>
									<option value="2">Contador</option>
									<option value="3">Supervisor</option>
									<option value="3">Secretario</option>
								</select>
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-primary">Grabar</button>
								<button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="btn-cerrar">Cerrar</button>

							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
		
		
		
		
		
		
		
		
		
		<!-- Formulario para eliminar -->
		<form id="form-eliminar" method="post" action="ServletEmpleado?accion=eliminar">
		<input type="hidden" name="codigo" id="codigo-empleado">
		</form>
		
	</div>
	<script src=https://code.jquery.com/jquery-3.7.1.js></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script src="https://cdn.datatables.net/2.0.3/js/dataTables.js"></script>
	<script src="https://cdn.datatables.net/2.0.3/js/dataTables.bootstrap5.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>
	
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
	
	<!-- Condicional para validar si existe MENSAJE -->
	<c:if test="${sessionScope.MENSAJE!=null}">
	<script>toastr.success('${sessionScope.MENSAJE}', 'SISTEMA', {timeOut: 5000});</script>
	</c:if>
	<!-- Eliminar atributo de tipo sesion MENSAJE -->
	<c:remove var="MENSAJE" scope="session"/>
	
	
	
	
	
	
	
	
	
	
	
	
	
	<script>
		//asignar evento click al boton con ID "btn-cerrar"
		$(document).on("click","#btn-cerrar",function(){
			//limpiar cajas
			$("#formEmpleado").trigger("reset");
			//resetear validacion
			$("#formEmpleado").bootstrapValidator("resetForm",true);
		})
	
		//asignar evento click a todos los botones con nombre de clase btn-eliminar
		$(document).on("click",".btn-eliminar",function(){
			//declarar variable cod
			let cod;
			cod=$(this).parents("tr").find("td")[0].innerHTML;
			//mostrar en la caja con ID "codigo-empleado" el codigo del empleado segun el boton eliminar seleccionado
			$("#codigo-empleado").val(cod);
			const swalWithBootstrapButtons = Swal.mixin({
				  customClass: {
				    confirmButton: "btn btn-success",
				    cancelButton: "btn btn-danger"
				  },
				  buttonsStyling: false
				});
				swalWithBootstrapButtons.fire({
				  title: "Seguro de eliminar?",
				  text: "",
				  icon: "warning",
				  showCancelButton: true,
				  confirmButtonText: "si",
				  cancelButtonText: "No",
				  reverseButtons: true
				}).then((result) => {
				  if (result.isConfirmed) {
				    //ejecutar el atributo accion del formulario con ID form-eliminar
				    $("#form-eliminar").submit();
				    
				  } else if (
				    /* Read more about handling dismissals below */
				    result.dismiss === Swal.DismissReason.cancel
				  ) {
				    swalWithBootstrapButtons.fire({
				      title: "Cancelled",
				      text: "Your imaginary file is safe :)",
				      icon: "error"
				    });
				  }
				});
		})
		
		//asignar evento click a todos los botones con ID "btn-editar"
		$(document).on("click",".btn-editar",function(){
			let cod;
			cod=$(this).parents("tr").find("td")[0].innerHTML;
			//leer JSON
			$.get("ServletEmpleado?accion=buscarPorId&codigo="+cod,function(response){
				//mostrar los valores que guarda response dentro de las cajas y los combos
			$("#id-codigo").val(response.codigo);
			$("#id-nombre").val(response.nombre);
			$("#id-paterno").val(response.parterno);
			$("#id-materno").val(response.materno);
			$("#id-sexo").val(response.sexo);
			$("#id-hijos").val(response.hijos);
			$("#id-sueldo").val(response.sueldo);
			$("#id-tipo").val(response.codigoTipoEmpleado);
			})
		})
	</script>
	
	
	
	
	
	
	
	
	<script>
	//invocar a la funcion leerEmpleado
	leerEmpleados();
	//funcion para leer el JSON que retorna el ServletEmpleadoJSON
	function leerEmpleados(){
		//$.get, funcion en JQUERY que permite leer un JSON
		$.get("ServletEmpleadoJSON",function(response){
			//console.log(response);
			//bucle para realizar recorido sobre response
			$.each(response,function(index,item){
				$("#tableEmpleados tbody").append(`
						<tr><td>\${item.codigo}</td>
						<td>\${item.nombre}</td>
						<td>\${item.parterno}</td>
						<td>\${item.materno}</td>
						<td>\${item.sexo}</td>
						<td>\${item.hijos}</td>
						<td>
						<button class="btn btn-success btn-editar" type="submit" data-bs-toggle="modal" data-bs-target="#modalEmpleado">Editar</button>
						<button class="btn btn-danger btn-eliminar" type="submit">Eliminar</button>
						</td></tr>
						`);
				
			})
			new DataTable('#tableEmpleados');
		})
	}
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<script>
		$(document).ready(function() {
			$('#formEmpleado').bootstrapValidator({
				fields : {
					nombre : {
						validators : {
							notEmpty : {
								message : "Ingresar nombre"
							},
							regexp:{
								regexp:/^[a-zA-Z\ñ\Ñ\á\é\í\ó\ú\Á\É\Í\Ó\Ú\s}]{3,30}$/,
								message: "Ingresar solo letras MIN:3 - MAX:30"
							}
						}
					},
					paterno : {
						validators : {
							notEmpty : {
								message : "Ingresar apellido paterno"
							},
							regexp:{
								regexp:/^[a-zA-Z\ñ\Ñ\á\é\í\ó\ú\Á\É\Í\Ó\Ú\s}]{3,30}$/,
								message: "Ingresar solo letras MIN:3 - MAX:30"
							}
						}
					},
					materno : {
						validators : {
							notEmpty : {
								message : "Ingresar apellido materno"
							},
							regexp:{
								regexp:/^[a-zA-Z\ñ\Ñ\á\é\í\ó\ú\Á\É\Í\Ó\Ú\s}]{3,30}$/,
								message: "Ingresar solo letras MIN:3 - MAX:30"
							}
						}
					},
					hijos : {
						validators : {
							notEmpty : {
								message : "Ingresar número de hijos"
							},
							regexp:{
								regexp:/^(\d|[1][0-5])$/,
								message: "Ingresar número de hijos rango 0-15"
							}
						}
					},
					sueldo : {
						validators : {
							notEmpty : {
								message : "Ingresar sueldo"
							},
							regexp:{
								regexp:/^([1][0][2-9][5-9]|[1][0][3-9]\d|[1][1-9]\d{2}|[2-4]\d{3}|[5][0]{3}|\d{4}(\.\d{1,2})?)$/,
								message: "Ingresar su sueldo rango 1025-5000"
							}
						}
					},
					sexo : {
						validators : {
							notEmpty : {
								message : "Ingresar sexo"
							}
						}
					},
					tipo : {
						validators : {
							notEmpty : {
								message : "Ingresar tipo de empleado"
							}
						}
					}

			
			
			
			
			
			
			
			
			
			
			
			
			
				}
			});

		});
	</script>
</body>
</html>