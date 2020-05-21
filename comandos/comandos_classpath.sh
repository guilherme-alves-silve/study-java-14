#!/bin/bash
#Remove arquivos antigos
rm -rf mods/

##Compilar com classpath
javac -d bin -cp bin \
src/main/java/br/com/guilhermealvessilve/jpms/modelo/dominio/Categoria.java \
src/main/java/br/com/guilhermealvessilve/jpms/modelo/dominio/Livro.java \
src/main/java/br/com/guilhermealvessilve/jpms/modelo/dominio/NotaFiscal.java \
src/main/java/br/com/guilhermealvessilve/jpms/http/dao/LivroDAO.java \
src/main/java/br/com/guilhermealvessilve/jpms/nf/servico/NotaFiscalServico.java \
src/main/java/br/com/guilhermealvessilve/jpms/nf/subscriber/NotaFiscalSubscriber.java \
src/main/java/br/com/guilhermealvessilve/jpms/nf/util/NotaFiscalUtil.java \
src/main/java/br/com/guilhermealvessilve/jpms/Principal.java

##Executar com classpath
java -cp bin br.com.guilhermealvessilve.jpms.Principal
