package pp;

public class Operaciones
{
    public int or(int q, int r)
    {
        if (q == 0 && r == 0)
            return 0;
        return 1;
    }

    public int and(int q, int r)
    {
        if (q == 1 && r == 1)
            return 1;
        return 0;
    }

    public int xor(int q, int r)
    {
        if (q == r)
            return 0;
        return 1;
    }

    public int not(int q)
    {
        if (q == 0)
            return 1;
        return 0;
    }

    public String binario(int n)
    {
        String bin = "";
        while (n != 0)
        {
            bin = (n % 2) + bin;
            n = n / 2;
        }
        while (bin.length() < 4)
        {
            bin = 0 + bin;
        }
        return bin;
    }

    public String NLFSR(String bin)
    {
        String nlfsr = "" + xor(or(and(toInt(bin.charAt(0)), toInt(bin.charAt(1))), not(toInt(bin.charAt(2)))), toInt(bin.charAt(3)));

        return nlfsr;
    }

    public String generar(String bin)
    {
        String aux = "";
        String nlfsr = "";
        for (int i = 0; i < 16; i++)
        {
            aux = NLFSR(bin);
            bin = aux + bin;
            nlfsr = nlfsr + bin.charAt(4);
        }
        return nlfsr;
    }

    public int toInt(char s)
    {
        return Integer.parseInt(s + "");
    }

    public boolean p1(String bin)
    {
        int x = contar0(bin);
        int y = contar1(bin);
        if (x == y)
        {
            return true;
        }
        if (x + 1 == y - 1 || x - 1 == y + 1)
            return true;
        if (x + 1 == y || x == y + 1)
            return true;
        return false;
    }

    public boolean p2(String bin)
    {
        if (rachas(bin, 1) == 5 && rachas(bin, 2) == 2 && rachas(bin, 3) == 1 && rachas(bin, 4) == 1)
            return true;
        return false;
    }
    public boolean p3(String bin)
    {
        for (int i = 1; i < bin.length(); i++)
        {
            System.out.println(cambiar(bin,i));
        }
        return false;
    }

    public int contar0(String bin)
    {
        int x = 0;
        for (int i = 0; i < bin.length(); i++)
        {
            if (bin.substring(i, i + 1).equals("0"))
                x++;
        }
        return x;
    }

    public int contar1(String bin)
    {
        int x = 0;
        for (int i = 0; i < bin.length(); i++)
        {
            if (bin.substring(i, i + 1).equals("1"))
                x++;
        }
        return x;
    }

    public int rachas(String bin, int n)
    {
        int x = 1;
        int cont = 0;
        for (int i = 1; i < bin.length(); i++)
        {
            if (bin.charAt(i) == bin.charAt(i - 1))
                x++;
            else
            {
                if (x == n)
                    cont++;
                x = 1;
            }
        }
        if (x == n)
            cont++;

        return cont;
    }
    public String cambiar(String bin,int x)
    {
        return bin.substring(x)+bin.substring(0,x);
    }
    private int comparar(String bin,String aux)
    {
        int x=0;
        for (int i = 0; i <bin.length() ; i++)
        {
            if (bin.charAt(i)==aux.charAt(i))
                x++;
        }
        return x;
    }
}