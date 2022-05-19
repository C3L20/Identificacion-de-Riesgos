package com.gestion.risk.Controller;

import java.util.List;

import com.gestion.risk.DaO.ProyDaO;
import com.gestion.risk.DaO.RiskDaO;
import com.gestion.risk.DaO.SolDaO;
import com.gestion.risk.model.PortafolioMdl;
import com.gestion.risk.model.ProgramaMdl;
import com.gestion.risk.model.ProyectoMdl;
import com.gestion.risk.model.RiskMdl;
import com.gestion.risk.model.SolMitgMdl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RiskCtrl {
    @Autowired
    private RiskDaO riskDaO;

    @Autowired
    private SolDaO solDaO;

    @Autowired
    private ProyDaO proyDaO;

    @RequestMapping(value = "getRisks")
    public List<RiskMdl> getRisks() {
        return riskDaO.getRisks();
    }

    @RequestMapping(value = "getSoluciones")
    public List<SolMitgMdl> getSoluciones() {
        return solDaO.getSoluciones();
    }

    @RequestMapping(value = "registrarRisk", method = RequestMethod.POST)
    public void registrarRisk(@RequestBody RiskMdl risk) {
        riskDaO.registrarRisk(risk);
    }

    @RequestMapping(value = "registrarSol", method = RequestMethod.POST)
    public void registrarRisk(@RequestBody SolMitgMdl sol) {
        solDaO.registrarSol(sol);
    }

    @RequestMapping(value = "registrarProyecto", method = RequestMethod.POST)
    public void registrarProy(@RequestBody ProyectoMdl proy) {
        proyDaO.registrarProy(proy);
    }

    @RequestMapping(value = "registrarPort", method = RequestMethod.POST)
    public void registrarPort(@RequestBody PortafolioMdl port) {
        proyDaO.registrarPort(port);
    }

    @RequestMapping(value = "registrarProg", method = RequestMethod.POST)
    public void registrarProg(@RequestBody ProgramaMdl prog) {
        proyDaO.registrarProg(prog);
    }

    @RequestMapping(value = "eliminarRisk/{idRisk}", method = RequestMethod.DELETE)
    public void eliminarRisk(@PathVariable int idRisk) {
        riskDaO.eliminarRisk(idRisk);
    }

    @RequestMapping(value = "eliminarSol/{idSol}", method = RequestMethod.DELETE)
    public void eliminarSol(@PathVariable int idSol) {
        System.out.println(idSol);
        riskDaO.eliminarSol(idSol);
    }
}
