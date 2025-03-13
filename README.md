# Guia de Configuração e Importação de Projetos de Automação

Este documento contém instruções para configurar sua máquina e importar os projetos criados para o Eclipse.

## **1. Configuração da Máquina**

Antes de importar os projetos, certifique-se de que sua máquina possui as seguintes ferramentas instaladas:

### **1.1 Instalar o Java JDK 11 ou superior**

Se ainda não possui o Java instalado, faça o download e instale:

- [Download do Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

Após a instalação, verifique a versão executando no terminal:

```sh
java -version
```

### **1.2 Instalar o Maven**

O Maven é necessário para gerenciar dependências nos projetos Maven.

- [Download do Maven](https://maven.apache.org/download.cgi)
- Após a instalação, verifique a versão:

```sh
mvn -version
```

### **1.3 Instalar o Eclipse**

- Baixe e instale a versão mais recente do Eclipse para **Desenvolvedores Java**:  [Download do Eclipse](https://www.eclipse.org/downloads/)

- No Eclipse, instale o plugin **Maven Integration for Eclipse** caso não esteja instalado:

  1. Vá até **Help > Eclipse Marketplace**
  2. Pesquise por **Maven Integration for Eclipse**
  3. Instale e reinicie o Eclipse.

### **1.4 Instalar o Allure Reports**

O Allure Reports é usado para gerar relatórios detalhados dos testes automatizados.

1. **Baixar e instalar o Allure**:

```sh
choco install allure  # Windows (Usando Chocolatey)
brew install allure   # MacOS (Usando Homebrew)
```

2. **Verifique se o Allure está instalado corretamente**:

```sh
allure --version
```

### **1.5 Instalar o Appium (Para Testes Mobile)**

Se for usar o projeto de testes mobile, instale o Appium:

```sh
npm install -g appium
```

Verifique a instalação com:

```sh
appium -v
```

---

## **2. Importação dos Projetos no Eclipse**

### **2.1 Importar Projetos Maven (API, Web e Mobile)**

1. **Baixe os arquivos ZIP dos projetos**:

   - E2E Web Automation (Maven)
   - API Test Automation
   - Mobile Test Automation
   - Performance Test (JMeter)

2. **Extraia os arquivos ZIP** em uma pasta de sua escolha.

3. **Abra o Eclipse** e vá até **File > Import...**.

4. Selecione **Maven > Existing Maven Projects** e clique em **Next**.

5. Clique em **Browse...** e selecione a pasta do projeto extraído.

6. O Eclipse detectará o projeto automaticamente. Clique em **Finish**.

7. Após importar, clique com o botão direito no projeto e selecione **Maven > Update Project...** para baixar as dependências.

### **2.2 Importar o Projeto de Teste de Performance (JMeter)**

1. Abra o **Apache JMeter**.
2. Vá até **File > Open** e selecione o arquivo `performance_test.jmx` dentro da pasta extraída do projeto `JMeter_Performance_Test`.
3. Configure os detalhes do teste conforme necessário.
4. Clique no botão **Run** (▶) para iniciar o teste de carga.

---

## **3. Executando os Testes**

### **3.1 Executar Testes Web e API (Selenium + Rest Assured + Cucumber)**

Após importar os projetos Maven, abra um terminal no Eclipse ou no diretório do projeto e execute:

```sh
mvn clean test
```

Se quiser gerar relatórios Allure após a execução:

```sh
mvn allure:report
```

Para visualizar o relatório interativo:

```sh
mvn allure:serve
```

### **3.2 Executar Testes Mobile (Appium + Selenium)**

1. Conecte um dispositivo Android ou inicie um emulador.
2. No terminal, execute:

```sh
mvn clean test
```

### **3.3 Executar Testes de Performance (JMeter)**

1. Abra o Apache JMeter.
2. Carregue o arquivo `performance_test.jmx`.
3. Clique em **Run (▶)** e aguarde a execução.
4. O JMeter salvará os resultados no arquivo `load_test_results.jtl`.

---

## **4. Solução de Problemas**

### **4.1 Erros de Dependências no Maven**

Se aparecer um erro como *"No goals have been specified for this build"* ou **erros de dependências**, tente:

```sh
mvn clean install
```

E depois:

```sh
mvn clean test
```

Se o erro persistir, atualize o projeto no Eclipse:

1. Clique com o botão direito no projeto.
2. Vá até **Maven > Update Project...**.
3. Marque **"Force Update of Snapshots/Releases"** e clique em **OK**.

### **4.2 Erros no Appium**

Se o Appium não encontrar o dispositivo, execute:

```sh
adb devices
```

Isso verificará se o dispositivo/emulador está conectado corretamente.

### **4.3 Erros no JMeter**

Se o JMeter não rodar corretamente, verifique se o Java está instalado corretamente com:

```sh
java -version
```
