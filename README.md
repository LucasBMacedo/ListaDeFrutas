📁 projeto: Filtragem de Alimentos por Grupo "Fruits" (CSV)

📝 descricao: >
  Aplicação em Java que lê um arquivo `.csv` contendo dados de alimentos, identifica quais pertencem ao grupo **"Fruits"** e exibe essas informações no console em formato tabular.  
  O programa valida a existência da pasta e do arquivo antes de iniciar a leitura.

🗂️ estrutura_arquivos:
  - 📄 src/controller/ArquivosController.java: >
      Contém os métodos responsáveis por:
      - Validar diretórios e arquivos
      - Ler arquivos com ou sem filtro
      - Filtrar registros do grupo "Fruits"
      - Exibir colunas específicas no console
  - 📄 src/controller/IArquivosController.java: >
      Interface com a definição dos métodos utilizados pela controller.
  - 📄 src/view/Principal.java: >
      Classe principal do projeto, responsável por instanciar a controller e executar a leitura filtrada do arquivo.

🧠 logica_filtragem:
  metodo: readFile(String path, String nome, int filter)
  explicacao: >
    - Valida o cabeçalho do CSV
    - Identifica os índices das colunas: FOOD NAME, SCIENTIFIC NAME, GROUP, SUB GROUP
    - Percorre cada linha e, se GROUP for igual a "Fruits", exibe os campos:
      - FOOD NAME
      - SCIENTIFIC NAME
      - SUB GROUP

💬 exemplo_saida_console: |
  Kiwi                 Actinidia chinensis     Tropical fruits
  Pineapple            Ananas comosus          Tropical fruits

📥 entrada:
  descricao: >
    O programa espera um arquivo chamado `generic_food.csv` (ou nome equivalente) dentro de uma pasta existente  
    (ex: `C:\TEMP` no Windows ou uma pasta válida no macOS/Linux).  
    O separador de colunas pode ser vírgula ou tabulação, conforme exportado.

📤 saida:
  descricao: >
    As informações dos alimentos do grupo "Fruits" são impressas no console em formato tabular.

🔗 dataset:
  nome: generic_food.csv
  origem: https://drive.google.com/open?id=1fsyrpTXbJuUcLa0TZKcu0g4aNLnNmiuB&usp=drive_fs

📌 observacoes:
  - 🛡️ O programa trata exceções como diretório/arquivo inválido e cabeçalhos ausentes.
  - 🔁 O método `readFile` aceita um filtro (0 para leitura completa, 1 para filtragem de "Fruits").
  - 💻 Compatível com Windows, macOS e Linux (ajustando o caminho do arquivo).

👨‍💻 autor:
  nome: Lucas Bezerra de Macedo
  assinatura: Criado por Lucas Bezerra de Macedo
