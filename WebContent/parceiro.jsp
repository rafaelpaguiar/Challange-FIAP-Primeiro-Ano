<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="resources/includes/header_include.jsp"%>
<title>iFood para Parceiros</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<br>
		</div>
		<div class="row">
			<div class="col">
				<svg width="68" height="37" viewBox="0 0 68 37" fill="none"
					xmlns="http://www.w3.org/2000/svg">
                    <g clip-path="url(#clip0_3:2)">
                    <path fill-rule="evenodd" clip-rule="evenodd"
						d="M0.5 21.9455H5.61864L8.5 6.98267H3.38136L0.5 21.9455Z"
						fill="#EA2F3C" />
                    <path fill-rule="evenodd" clip-rule="evenodd"
						d="M3.5 3.99009H9.50568L10.5 0H4.45455L3.5 3.99009Z"
						fill="#EA2F3C" />
                    <path fill-rule="evenodd" clip-rule="evenodd"
						d="M7.5 24.9381H12.489L15.5286 9.30931H19.163L19.7247 6.42139H16.0573L16.1894 5.74188C16.4207 4.51875 16.8172 3.09178 18.7004 3.09178C19.8238 3.09178 20.8811 3.22768 21.9383 3.66937L22.5 0.645536C21.3767 0.203854 20.1211 0 18.8987 0C14.8678 0 12.1256 2.5142 11.1013 6.42139H9.35022L8.82159 9.30931H10.5396L7.5 24.9381Z"
						fill="#EA2F3C" />
                    <path fill-rule="evenodd" clip-rule="evenodd"
						d="M24.0705 21.9455C29.6411 21.9455 33.5 16.3513 33.5 11.7681C33.5 8.43177 30.6369 6.98267 27.9295 6.98267C21.8299 6.98267 18.5 13.015 18.5 17.1601C18.5 20.4627 21.3631 21.9455 24.0705 21.9455Z"
						fill="#EA2F3C" />
                    <path fill-rule="evenodd" clip-rule="evenodd"
						d="M39.4419 21.9455C45.3838 21.9455 49.5 16.3513 49.5 11.7681C49.5 8.43177 46.4461 6.98267 43.5581 6.98267C37.0519 6.98267 33.5 13.015 33.5 17.1601C33.5 20.4627 36.5871 21.9455 39.4419 21.9455Z"
						fill="#EA2F3C" />
                    <path fill-rule="evenodd" clip-rule="evenodd"
						d="M57.7336 21.6285H63.0607L67.5 0H62.1374L60.7168 6.65763C60.0065 6.51673 59.2963 6.41105 58.5505 6.41105C53.2944 6.41105 48.5 13.1743 48.5 18.0002C48.5 19.9729 49.7785 21.9455 51.9449 21.9455C55.0346 21.9455 57.1654 20.4308 58.0533 18.9866H58.3729L57.7336 21.6285Z"
						fill="#EA2F3C" />
                    <path fill-rule="evenodd" clip-rule="evenodd"
						d="M41.9313 32.0717C38.3625 35.4788 33.6042 37.2179 28.4601 36.863C21.9335 36.4016 17.4324 30.7231 16.5 24.9736H16.8215C18.3004 28.6646 21.8692 32.0362 26.3381 32.6041C30.7106 33.1364 36.0798 30.936 39.0055 27.7418L35.694 24.9381L45.5 24.9736L43.378 36.65L41.9313 32.0717Z"
						fill="#EA2F3C" />
                    </g>
                    <defs>
                    <clipPath id="clip0_3:2">
                    <rect width="68" height="37" fill="white" />
                    </clipPath>
                    </defs>
                </svg>
			</div>
		</div>
		<div class="row">
			<br>
		</div>
		<div class="row">
			<div class="col grey-bg">
				<span class="grey-title">
					<div class="spacer-10"></div> Informações da loja<br>
				</span> Preencha abaixo as informações sobre a sua futura loja no iFood com
				os dados do seu negócio.
				<div class="spacer-10"></div>
				<div class="mb-3 white-form">
					<form class="row g-3" action="parceiro" method="post">
						<div class="col-12">
							<label for="inputNomeCNPJ" class="form-label">CNPJ (somento números)</label> <input
								type="text" class="form-control" id="inputNomeCNPJ"
								name="inputNomeCNPJ">
						</div>
						<div class="col-12">
							<label for="inputRazaoSocial" class="form-label">Razão
								Social</label> <input type="text" class="form-control"
								id="inputRazaoSocial" name="inputRazaoSocial">
						</div>
						<div class="col-12">
							<label for="inputNomeFantasia" class="form-label">Nome da
								loja (como aparecerá no app)</label> <input type="text"
								class="form-control" id="inputNomeFantasia"
								name="inputNomeFantasia">
						</div>
						<div class="col-12">
							<label for="inputEmailDaLoja" class="form-label">Email da
								loja</label> <input type="email" class="form-control"
								id="inputEmailDaLoja" name="inputEmailDaLoja">
						</div>
						<div class="col-12">
							<label for="inputCategoria" class="form-label"><strong>Especialidade</strong></label>
							<select class="form-control" id="inputCategoria"
								name="inputCategoria">
								<option value="Campo obrigatório" selected>Campo
									obrigatório</option>
								<option value="Africana">Africana</option>
								<option value="Alemã">Alemã</option>
								<option value="Açaí">Açaí</option>
								<option value="Árabe">Árabe</option>
								<option value="Argentina">Argentina</option>
								<option value="Bebidas">Bebidas</option>
								<option value="Brasileira">Brasileira</option>
								<option value="Cafeteria">Cafeteria</option>
								<option value="Carnes">Carnes</option>
								<option value="Casa de Sucos">Casa de Sucos</option>
								<option value="Chinesa">Chinesa</option>
								<option value="Colombiana">Colombiana</option>
								<option value="Congelados">Congelados</option>
								<option value="Conveniência">Conveniência</option>
								<option value="Coreana">Coreana</option>
								<option value="Doces & Bolos">Doces & Bolos</option>
								<option value="Espanhola">Espanhola</option>
								<option value="Francesa">Francesa</option>
								<option value="Frutos do mar">Frutos do mar</option>
								<option value="Indiana">Indiana</option>
								<option value="Italiana">Italiana</option>
								<option value="Japonesa">Japonesa</option>
								<option value="Lanches">Lanches</option>
								<option value="Marmita">Marmita</option>
								<option value="Mediterrânea">Mediterrânea</option>
								<option value="Mexicana">Mexicana</option>
								<option value="Padaria">Padaria</option>
								<option value="Pastel">Pastel</option>
								<option value="Peixes">Peixes</option>
								<option value="Peruana">Peruana</option>
								<option value="Pizza">Pizza</option>
								<option value="Portuguesa">Portuguesa</option>
								<option value="Salgados">Salgados</option>
								<option value="Saudável">Saudável</option>
								<option value="Sorvetes">Sorvetes</option>
								<option value="Tailandesa">Tailandesa</option>
								<option value="Vegetariana">Vegetariana</option>
							</select>
						</div>
						<div class="col-12">
							<input type="hidden" class="form-control" id="inputIdLoja"
								name="inputIdLoja" value="${idLoja}"><br>
						</div>
				</div>
				<div class="col-12 d-flex align-items-end flex-column">
					<button type="submit" class="btn btn-primary btn-ifood">Continuar</button>
				</div>
				</form>
				<div class="spacer-10"></div>
			</div>
		</div>
	</div>
	</div>
	<%@ include file="resources/includes/footer_include.jsp"%>
</body>
</html>