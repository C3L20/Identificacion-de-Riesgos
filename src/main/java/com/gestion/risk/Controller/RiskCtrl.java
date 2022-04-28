package com.gestion.risk.Controller;

import java.util.List;

import com.gestion.risk.DaO.RiskDaO;
import com.gestion.risk.DaO.SolDaO;
import com.gestion.risk.model.RiskMdl;
import com.gestion.risk.model.SolMitgMdl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiskCtrl {
    @Autowired
    private RiskDaO riskDaO;

    @Autowired
    private SolDaO solDaO;

    @RequestMapping(value = "getRisks")
    public List<RiskMdl> getRisks() {
        return riskDaO.getRisks();
    }

    @RequestMapping(value = "getSoluciones")
    public List<SolMitgMdl> getSoluciones() {
        return solDaO.getSoluciones();
    }
}
