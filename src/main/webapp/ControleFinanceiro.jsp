<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UP - CONTROLE DE GASTOS</title>

    <!-- Chamada da fonte, GOOGLE FONTS -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
    <!-- Chamada CDN FONT AWESOME -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- Chamada CDN BOOTSTRAP -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

    <!-- Chamada CDN JQUERY -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha384-vtXRuZXI5FTTzP2G06/7PZtNzkRJyYmO1+M3o2a6mcj5Bm3hdH+6S+StsLeW0tmd" crossorigin="anonymous"></script>

    <!-- Chamadas do CSS -->
    <link rel="stylesheet" href="./resources/css/styles.css">
    <link rel="stylesheet" href="./resources/css/bootstrap">
    
</head>
<!-- BODY INIT -->
<body>

<!-- chamada Navbar -->
<nav class="navbar navbar-expand-lg bg-body-tertiary bg-primary">
    <div class="container-fluid bg-primary">
        <a class="navbar-brand" href="../../index.html">
            <img src="../images/icon_UPINVESTIMENTOS.jpg" alt="" width="30" height="24" class="d-inline-block align-text-top">
            UP INVESTIMENTOS
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="../../index.html">HOME</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./ctrlfinanceiro_home.html">CONTROLE FINANCEIRO</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./invest_home.html">INVESTIMENTOS</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Titulo da página -->
<h1 class="text-center">CONTROLE FINANCEIRO</h1>
<h2 class="text-center mt-4">CADASTRAR DESPESAS</h2>

<!-- Criação dos campos de entrada do cadastro de despesas -->
<form class="dados mb-3" id="dados" method="get" action="">
    <div class="row mb-3 mx-2">
        <!-- Adicionei mais atributos ao campo de data -->
        <div class="col-md-4  my-2">
            <label for="data" class="form-label">Data</label>
            <input type="date" class="form-control" id="data" name="dataCadastro" required>
        </div>

        <!-- Adicionei um 'name' aos 'select' -->
        <div class="col-md-4  my-2">
            <label for="tipo" class="form-label">Tipo</label>
            <select id="tipo" class="form-select" name="tipo" required>
                <!-- Adicionei valores aos options -->
                <option value="">Selecione entrada ou saída de dinheiro</option>
                <option value="Entrada">Entrada</option>
                <option value="Saída">Saída</option>
            </select>
        </div>

        <!-- Adicionei 'name' aos campos -->
        <div class="col-md-4 my-2">
            <label for="descricao" class="form-label">Descrição</label>
            <input type="text" class="form-control" id="descricao" name="descricao" placeholder="ex: Almoço sexta-feira" required autofocus>
        </div>
        <!-- Adicionei um 'name' aos 'select' -->
        <div class="col-md-4  my-2">
            <label for="categoria" class="form-label">Categoria</label>
            <select id="categoria" class="form-select" name="categoria" required>
                <!-- Adicionei valores aos options -->
                <option value="">Selecione o tipo de conta</option>
                <option value="Entrada Salário">Entrada Salário</option>
                <option value="Entrada Diversas">Entrada Diversas</option>
                <!-- Outras opções -->
            </select>
        </div>

        <!-- Adicionei 'name' ao campo -->
        <div class="col-md-4  my-2">
            <label for="valor" class="form-label">Valor</label>
            <input type="text" class="form-control" id="valor" name="valor" placeholder="Digite o valor R$" required>
        </div>

        <!-- Adicionei 'name' ao campo -->
        <div class="col-md-4 my-2">
            <label for="comentario" class="form-label">Comentário</label>
            <input type="text" class="form-control" id="comentario" name="comentario" placeholder="Almoço com amigos" required autofocus>
        </div>

    </div>

    <div class="d-flex justify-content-center mt-6">
        <button type="submit" class="btn btn-primary">INSERIR</button>
    </div>
</form>
</body>
</html>
