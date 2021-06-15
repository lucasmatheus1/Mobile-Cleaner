package br.edu.ifpb.ActionDashboard.CleaningTipsStrategy;

public class DefaultTips implements ICleaningTips{
    @Override
    public String show() {
        return "Não temos dicas para seu Smartphone no momento.";
    }
}

