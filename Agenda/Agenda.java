class PrincipalAgenda {
    public static void main (String args[]){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {        
            public void run() {
                TelaGeral tg = new TelaGeral();
            }
        });
    }
}

