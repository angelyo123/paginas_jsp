<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link https://cdn.datatables.net/2.0.3/css/dataTables.bootstrap5.css>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"
	rel="stylesheet">
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

<body>


	<div class="container">

		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal"
			data-bs-target="#modalJuguetes">Launch demo modal</button>



		<table id="tableJuguetes" class="table table-striped">


			<thead>
				<tr>
					<th># codigo</th>
					<th>nombre</th>
					<th>precio</th>
					<th>cantidad</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			</tbody>


		</table>






		<!-- Modal -->
		<div class="modal fade" id="modalJuguetes" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Modal
							title</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">

						<form id="formJuguetes" method="post"
							action="ServletJuguetes?accion=grabar">


							<div class="form-group">
								<label class="form-label">nombre de juguete</label> <input
									type="text" class="form-control" name="nombre">
							</div>

							<div class="form-group">
								<label class="form-label">precio de juguete</label> <input
									type="text" class="form-control" name="precio">
							</div>

							<div class="form-group">
								<label class="form-label">cantidad</label> <input type="text"
									class="form-control" name="cantidad">
							</div>

							<div class="modal-footer">

								<button type="submit" class="btn btn-primary">grabar</button>
							</div>

						</form>

					</div>

				</div>
			</div>
		</div>
		
		<form id="form-eliminar" method="post" action="ServletJuguetes?accion=eliminar">
		<input type="hidden" name="codigo" id="codigo-juguete">
		</form>

	</div>







	<script src=https://code.jquery.com/jquery-3.7.1.js></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script src="https://cdn.datatables.net/2.0.3/js/dataTables.js"></script>
	<script
		src="https://cdn.datatables.net/2.0.3/js/dataTables.bootstrap5.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>

	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		
		
		
		<script>
		
				$(document).on("click", ".btn-eliminar", function(){
					
					let cod;
					cod=$(this).parents("tr").find("td")[0].innerHTML;
					//mostrar en la caja con ID "codigo-empleado" el codigo del empleado segun el boton eliminar seleccionado
					$("#codigo-juguete").val(cod);
					
					Swal.fire({
						  title: "Are you sure?",
						  text: "You won't be able to revert this!",
						  icon: "warning",
						  showCancelButton: true,
						  confirmButtonColor: "#3085d6",
						  cancelButtonColor: "#d33",
						  confirmButtonText: "Yes, delete it!"
							cancelButtonText: "no"
						}).then((result) => {
						  if (result.isConfirmed) {
							  $("#form-eliminar").submit();
						  }
						});
					
				})
		
		</script>
		
		<script>
		
		leerJuguetes()
		
				function leerJuguetes(){
					$.get( "ServletJuguetesJSON",function(response){
						$.each(response,function(index,item){
							$("#tableJuguetes tbody").append(`
									
									<tr><td>\${item.codigo}</td>
									<td>\${item.nombre}</td>
									<td>\${item.precio}</td>
									<td>\${item.cantidad}</td>
								
						
									<td>
									<button class="btn btn-success btn-editar" type="submit" data-bs-toggle="modal" data-bs-target="#modalJuguetes">Editar</button>
									<button class="btn btn-danger btn-eliminar" type="submit">Eliminar</button>
									</td></tr>
									
									
									`)
							
							
							
							
						})
							new DataTable('#tableJuguetes');
						
					})
				}
		
		</script>
		
		

</body>
</html>