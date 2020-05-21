#!/bin/bash
#Remove arquivos antigos
rm -rf mods/

##Compilar com module path
javac -d mods/br.com.guilhermealvessilve --module-path mods \
src-modulos/br.com.guilhermealvessilve/src/br/com/guilhermealvessilve/jpms/modelo/dominio/Categoria.java \
src-modulos/br.com.guilhermealvessilve/src/br/com/guilhermealvessilve/jpms/modelo/dominio/Livro.java \
src-modulos/br.com.guilhermealvessilve/src/br/com/guilhermealvessilve/jpms/modelo/dominio/NotaFiscal.java \
src-modulos/br.com.guilhermealvessilve/src/br/com/guilhermealvessilve/jpms/http/dao/LivroDAO.java \
src-modulos/br.com.guilhermealvessilve/src/br/com/guilhermealvessilve/jpms/nf/servico/NotaFiscalServico.java \
src-modulos/br.com.guilhermealvessilve/src/br/com/guilhermealvessilve/jpms/nf/subscriber/NotaFiscalSubscriber.java \
src-modulos/br.com.guilhermealvessilve/src/br/com/guilhermealvessilve/jpms/nf/util/NotaFiscalUtil.java \
src-modulos/br.com.guilhermealvessilve/src/br/com/guilhermealvessilve/jpms/Principal.java \
src-modulos/br.com.guilhermealvessilve/src/module-info.java

##Executar com module path
java --module-path mods -m br.com.guilhermealvessilve/br.com.guilhermealvessilve.jpms.Principal
