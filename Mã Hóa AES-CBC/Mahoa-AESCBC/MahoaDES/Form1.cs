using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using System.Data.OleDb;

namespace MahoaDES
{
    public partial class Form1 : Form
    {
        
        public Form1()
        {
            InitializeComponent();

        }
        public String[,] cypherText = new String[4, 4];
        public String[,] plainText = new String[4, 4];
        public String[,] khoa = new String[4, 4];
        public String[,] khoa_1 = new String[4, 4];
        public String[,] khoa_2 = new String[4, 4];
        public String[,] khoa_3 = new String[4, 4];
        public String[,] khoa_4 = new String[4, 4];
        public String[,] khoa_5 = new String[4, 4];
        public String[,] khoa_6 = new String[4, 4];
        public String[,] khoa_7 = new String[4, 4];
        public String[,] khoa_8 = new String[4, 4];
        public String[,] khoa_9 = new String[4, 4];
        public String[,] khoa_10 = new String[4, 4];
        public String[,] addRoundKey = new String[4, 4];
        public String[,] subBytes = new String[4, 4];
        public String[,] shiftRows = new String[4, 4];
        public String[,] mixColumns = new String[4, 4];

        /*======================================GIẢI MÃ=======================================*/




        /*============================================================================================*/

        public Boolean checkXOR(String s1)
        {
            Boolean check = true;

            String checking = "0123456789abc def";

            for (int i = 0; i < s1.Length; i++)
            {
                if (!checking.Contains(s1[i]))
                {
                    check = false;
                    MessageBox.Show("Vui lòng xóa kí tự: " + s1[i] + "\n");
                }


            }
            return check;

        }

        public String connectString(String[] array)
        {
            String result = "";
            foreach (var item in array)
            {
                result += item;
            }
            return result;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }
        string Get16From2(string sBinary)
        {
            string rest = "", tmp, chr = "0000";
            int len = sBinary.Length; // 4;
            chr = chr.Substring(0, len);
            //sBinary = chr+sBinary;
            for (int i = 0; i < sBinary.Length; i += 4)
            {
                tmp = sBinary.Substring(i, 4);
                if (!tmp.Equals("0000"))
                {
                    rest = rest + "0";
                }
                else if (!tmp.Equals("0001"))
                {
                    rest = rest + "1";
                }
                else if (!tmp.Equals("0010"))
                {
                    rest = rest + "2";
                }
                else if (!tmp.Equals("0011"))
                {
                    rest = rest + "3";
                }
                else if (!tmp.Equals("0100"))
                {
                    rest = rest + "4";
                }
                else if (!tmp.Equals("0101"))
                {
                    rest = rest + "5";
                }
                else if (!tmp.Equals("0110"))
                {
                    rest = rest + "6";
                }
                else if (!tmp.Equals("0111"))
                {
                    rest = rest + "7";
                }
                else if (!tmp.Equals("1000"))
                {
                    rest = rest + "8";
                }
                else if (!tmp.Equals("1001"))
                {
                    rest = rest + "9";
                }
                else if (!tmp.Equals("1010"))
                {
                    rest = rest + "a";
                }
                else if (!tmp.Equals("1011"))
                {
                    rest = rest + "b";
                }
                else if (!tmp.Equals("1100"))
                {
                    rest = rest + "c";
                }
                else if (!tmp.Equals("1101"))
                {
                    rest = rest + "d";
                }
                else if (!tmp.Equals("1110"))
                {
                    rest = rest + "e";
                }
                else if (!tmp.Equals("1111"))
                {
                    rest = rest + "f";
                }
                else
                {
                    continue;
                }
            }
            return rest;
        }

        public void input(String[] key, String[] plainTextStr)
        {

            //=========================================================================================//



            int i = 0;
            int j = 0;
            foreach (String w in plainTextStr)
            {
                plainText[i, j] = w;
                i++;
                if (i > 3 && j != 3)
                {
                    i = 0;
                    j++;
                }

            }


            int a = 0;
            int b = 0;
            foreach (String w in key)
            {
                khoa[a, b] = w;
                a++;
                if (a > 3 && b != 3)
                {
                    a = 0;
                    b++;
                }

            }

        }
        public void xuatmatran(String[,] matran)
        {
            for (int i = 0; i <= 3; i++)
                for (int j = 0; j <= 3; j++)
                {

                    if (j == 3) richTextBox1.Text += "  " + matran[i, j] + "\n";
                    else richTextBox1.Text += "  " + matran[i, j] + " ";

                }
        }
        private void AddRoundKey()
        {
            richTextBox1.Text += "AddRoundKey : \n";
            for (int i = 0; i <= 3; i++)

                for (int j = 0; j <= 3; j++)
                {
                    addRoundKey[i, j] = AESCBC.XOR16(plainText[i, j], khoa[i, j]);
                    if (j == 3) richTextBox1.Text += "  " + addRoundKey[i, j] + "\n";
                    else richTextBox1.Text += "  " + addRoundKey[i, j] + " ";

                }

        }
        private void AddRoundKeyvonglap(String[,] kqdr, String[,] khoamoi)
        {
            richTextBox1.Text += "Kết quả AddRoundKey: \n";
            for (int i = 0; i <= 3; i++)
                for (int j = 0; j <= 3; j++)
                {
                    addRoundKey[i, j] = AESCBC.XOR16(kqdr[i, j], khoamoi[i, j]);
                    if (j == 3) richTextBox1.Text += "  " + addRoundKey[i, j] + "\n";
                    else richTextBox1.Text += "  " + addRoundKey[i, j] + " ";

                }
        }
        private void SubBytes()
        {
            richTextBox1.Text += "SubBytes : \n";
            for (int i = 0; i <= 3; i++)
                for (int j = 0; j <= 3; j++)
                {
                    String ark = addRoundKey[i, j];
                    subBytes[i, j] = AESCBC.sbox[AESCBC.chuyen16sangso(ark[0]), AESCBC.chuyen16sangso(ark[1])];
                    if (j == 3) richTextBox1.Text += "  " + subBytes[i, j] + "\n";
                    else richTextBox1.Text += "  " + subBytes[i, j] + " ";
                }

        }
        public void ShiftRows()
        {
            String teap;
            teap = subBytes[1, 0];
            subBytes[1, 0] = subBytes[1, 3];
            subBytes[1, 3] = teap;
            teap = subBytes[1, 0];
            subBytes[1, 0] = subBytes[1, 2];
            subBytes[1, 2] = teap;
            teap = subBytes[1, 0];
            subBytes[1, 0] = subBytes[1, 1];
            subBytes[1, 1] = teap;

            teap = subBytes[2, 0];
            subBytes[2, 0] = subBytes[2, 2];
            subBytes[2, 2] = teap;
            teap = subBytes[2, 1];
            subBytes[2, 1] = subBytes[2, 3];
            subBytes[2, 3] = teap;

            teap = subBytes[3, 0];
            subBytes[3, 0] = subBytes[3, 3];
            subBytes[3, 3] = teap;
            teap = subBytes[3, 1];
            subBytes[3, 1] = subBytes[3, 3];
            subBytes[3, 3] = teap;
            teap = subBytes[3, 2];
            subBytes[3, 2] = subBytes[3, 3];
            subBytes[3, 3] = teap;

            shiftRows = subBytes;
            richTextBox1.Text += "ShiftRows : \n";
            xuatmatran(shiftRows);

        }
        public void MixColumns()
        {
            for (int j = 0; j <= 3; j++)
            {
                String[] lay1cot = new String[4];
                for (int i = 0; i <= 3; i++)
                {
                    lay1cot[i] = shiftRows[i, j];
                }
                for (int k = 0; k <= 3; k++)
                {
                    String[] kqsaubangbd = new String[4];
                    for (int q = 0; q <= 3; q++)
                    {
                        kqsaubangbd[q] = AESCBC.nhanbangbd(lay1cot[q], AESCBC.matranbd[k, q]);
                    }
                    mixColumns[k, j] = AESCBC.XOR16voi4kytu(kqsaubangbd[0], kqsaubangbd[1], kqsaubangbd[2], kqsaubangbd[3]);
                }
            }
            richTextBox1.Text += "MixColumns : \n";
            xuatmatran(mixColumns);
        }

        public void tao10khoa()
        {
            richTextBox1.Text += "Tính khóa : " + "\n";
            for (int i = 1; i <= 10; i++)
            {
                String[] R_con = new String[4];
                R_con = AESCBC.layR_con(i);

                if (i == 1)
                {
                    khoa_1 = AESCBC.tinhkhoa(R_con, khoa);
                    richTextBox1.Text += "Khóa 1 " + "\n";
                    xuatmatran(khoa_1);
                }
                else if (i == 2)
                {
                    khoa_2 = AESCBC.tinhkhoa(R_con, khoa_1);
                    richTextBox1.Text += "Khóa 2 " + "\n";
                    xuatmatran(khoa_2);
                }
                else if (i == 3)
                {
                    khoa_3 = AESCBC.tinhkhoa(R_con, khoa_2);
                    richTextBox1.Text += "Khóa 3 " + "\n";
                    xuatmatran(khoa_3);
                }
                else if (i == 4)
                {
                    khoa_4 = AESCBC.tinhkhoa(R_con, khoa_3);
                    richTextBox1.Text += "Khóa 4 " + "\n";
                    xuatmatran(khoa_4);
                }
                else if (i == 5)
                {
                    khoa_5 = AESCBC.tinhkhoa(R_con, khoa_4);
                    richTextBox1.Text += "Khóa 5 " + "\n";
                    xuatmatran(khoa_5);
                }
                else if (i == 6)
                {
                    khoa_6 = AESCBC.tinhkhoa(R_con, khoa_5);
                    richTextBox1.Text += "Khóa 6 " + "\n";
                    xuatmatran(khoa_6);
                }
                else if (i == 7)
                {
                    khoa_7 = AESCBC.tinhkhoa(R_con, khoa_6);
                    richTextBox1.Text += "Khóa 7 " + "\n";
                    xuatmatran(khoa_7);
                }
                else if (i == 8)
                {
                    khoa_8 = AESCBC.tinhkhoa(R_con, khoa_7);
                    richTextBox1.Text += "Khóa 8 " + "\n";
                    xuatmatran(khoa_8);
                }
                else if (i == 9)
                {
                    khoa_9 = AESCBC.tinhkhoa(R_con, khoa_8);
                    richTextBox1.Text += "Khóa 9 " + "\n";
                    xuatmatran(khoa_9);
                }
                else if (i == 10)
                {
                    khoa_10 = AESCBC.tinhkhoa(R_con, khoa_9);
                    richTextBox1.Text += "Khóa 10 " + "\n";
                    xuatmatran(khoa_10);
                }
            }
        }
        private void btnMaHoa_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Chương trình đang chạy, mong thầy và các bạn chờ trong giây phút! ", "Thông báo");
            int khoadai = txtbanro.Text.Split(' ').Length;
            int banrodai = txtkhoa.Text.Split(' ').Length;

            String[] plainTextStr = txtbanro.Text.Split(' '); //cắt
            String[] key = txtkhoa.Text.Split(' ');

            String plaintextt = connectString(plainTextStr);
            String keytext = connectString(key);

            try
            {
                String khoa = txtkhoa.Text;
                String banro = txtbanro.Text;
                //&& khoadai == 16 && banrodai == 16



                if (checkXOR(khoa) != false && checkXOR(banro) != false && txtbanro.Text != "" && txtkhoa.Text != "")
                {
                    //MessageBox.Show(txtkhoa.Text);
                    richTextBox1.Text = "";

                    /*============================*/
                    String[] Plaintext = txtbanro.Text.Split(' '); //cắt
                    String[] khoaIV = txtIV.Text.Split(' ');
                    String[] result = new string[plainText.Length]; //lưu kết quả lần lặp sau
                                                                    //foreach (String i in )

                    String[] plainTextSt = new string[plainText.Length];

                    richTextBox1.Text += "========================Lặp lần 1 (AES): ========================= \n";
                    richTextBox1.Text += "XOR IV và bản rõ: \n";

                    //XOR và lưu vào PlaintextST
                    for (int it = 0; it < Plaintext.Length; it++)
                    {
                        plainTextSt[it] = AESCBC.XOR16(Plaintext[it], khoaIV[it]);

                    }

                    int demhang = 0, demcot = 0;

                    for (int t = 0; t < plainText.Length; t++)
                    {
                        richTextBox1.Text += plainTextSt[t];
                        demhang++;
                        demcot++;

                        if (demhang == 1)
                        {
                            richTextBox1.Text += " ";

                            demhang = 0;

                        }

                        if (demcot == 4)
                        {
                            richTextBox1.Text += "\n";
                            demcot = 0;
                        }
                    }
                    richTextBox1.Text += "\n";
                    /*===========================*/
                    input(txtkhoa.Text.Split(' '), plainTextSt);





                    tao10khoa();
                    AddRoundKey();

                    for (int i = 1; i <= 9; i++)
                    {
                        richTextBox1.Text += "Vòng lặp thứ " + i + " : " + "\n";
                        SubBytes();
                        ShiftRows();
                        MixColumns();

                        if (i == 1) AddRoundKeyvonglap(mixColumns, khoa_1);
                        else if (i == 2) AddRoundKeyvonglap(mixColumns, khoa_2);
                        else if (i == 3) AddRoundKeyvonglap(mixColumns, khoa_3);
                        else if (i == 4) AddRoundKeyvonglap(mixColumns, khoa_4);
                        else if (i == 5) AddRoundKeyvonglap(mixColumns, khoa_5);
                        else if (i == 6) AddRoundKeyvonglap(mixColumns, khoa_6);
                        else if (i == 7) AddRoundKeyvonglap(mixColumns, khoa_7);
                        else if (i == 8) AddRoundKeyvonglap(mixColumns, khoa_8);
                        else if (i == 9) AddRoundKeyvonglap(mixColumns, khoa_9);

                    }
                    richTextBox1.Text += "Bước tạo ngõ ra : " + "\n";
                    SubBytes();
                    ShiftRows();

                    richTextBox1.Text += "Bản mã :\n";
                    for (int i = 0; i <= 3; i++)
                        for (int j = 0; j <= 3; j++)
                        {
                            addRoundKey[i, j] = AESCBC.XOR16(shiftRows[i, j], khoa_10[i, j]);
                            if (j == 3) richTextBox1.Text += "  " + addRoundKey[i, j] + "\n";
                            else richTextBox1.Text += "  " + addRoundKey[i, j] + " ";

                        }

                    int count = 0;
                    for (int i = 0; i <= 3; i++)
                        for (int j = 0; j <= 3; j++)
                        {
                            txtmahoa.Text += addRoundKey[i, j] + " ";
                            result[count] = addRoundKey[i, j] + " ";
                            count++;
                        }

                    richTextBox1.Text += "\n=================================================================\n";


                    //xong bước 1=============================================================:

                    for (int k = 0; k < 9; k++)
                    {
                        richTextBox1.Text += "========================Lặp lần " + (k + 2) + "(AES): ========================= \n";

                        richTextBox1.Text += "XOR ciphertext và Plaintext: \n";
                        for (int it = 0; it < Plaintext.Length; it++)
                        {
                            plainTextSt[it] = AESCBC.XOR16(Plaintext[it], result[it]);

                        }

                        //show kết quả:
                        demhang = 0;
                        demcot = 0;

                        for (int t = 0; t < plainText.Length; t++)
                        {
                            richTextBox1.Text += plainTextSt[t];
                            demhang++;
                            demcot++;

                            if (demhang == 1)
                            {
                                richTextBox1.Text += " ";

                                demhang = 0;

                            }

                            if (demcot == 4)
                            {
                                richTextBox1.Text += "\n";
                                demcot = 0;
                            }
                        }
                        //============================================================

                        input(txtkhoa.Text.Split(' '), plainTextSt);
                        AddRoundKey();

                        for (int i = 1; i <= 9; i++)
                        {
                            richTextBox1.Text += "Vòng lặp thứ " + i + " : " + "\n";
                            SubBytes();
                            ShiftRows();
                            MixColumns();

                            if (i == 1) AddRoundKeyvonglap(mixColumns, khoa_1);
                            else if (i == 2) AddRoundKeyvonglap(mixColumns, khoa_2);
                            else if (i == 3) AddRoundKeyvonglap(mixColumns, khoa_3);
                            else if (i == 4) AddRoundKeyvonglap(mixColumns, khoa_4);
                            else if (i == 5) AddRoundKeyvonglap(mixColumns, khoa_5);
                            else if (i == 6) AddRoundKeyvonglap(mixColumns, khoa_6);
                            else if (i == 7) AddRoundKeyvonglap(mixColumns, khoa_7);
                            else if (i == 8) AddRoundKeyvonglap(mixColumns, khoa_8);
                            else if (i == 9) AddRoundKeyvonglap(mixColumns, khoa_9);

                        }


                        richTextBox1.Text += "Bước tạo ngõ ra : " + "\n";
                        SubBytes();
                        ShiftRows();


                        richTextBox1.Text += "Bản mã :\n";
                        for (int i = 0; i <= 3; i++)
                            for (int j = 0; j <= 3; j++)
                            {
                                addRoundKey[i, j] = AESCBC.XOR16(shiftRows[i, j], khoa_10[i, j]);
                                if (j == 3) richTextBox1.Text += "  " + addRoundKey[i, j] + "\n";
                                else richTextBox1.Text += "  " + addRoundKey[i, j] + " ";

                            }

                        txtmahoa.Text = "";
                        count = 0;
                        for (int i = 0; i <= 3; i++)
                            for (int j = 0; j <= 3; j++)
                            {
                                txtmahoa.Text += addRoundKey[i, j] + " ";
                                result[count] = addRoundKey[i, j] + " ";
                                count++;
                            }



                    }





                }
                else
                {
                    MessageBox.Show("Nhập sai!", "Thông Báo");
                    //MessageBox.Show(checkXOR(plaintextt) + "", "Thông Báo");
                    //MessageBox.Show(checkXOR(keytext) + "", "Thông Báo");
                }
            }

            catch (Exception ex)
            {
                richTextBox1.Text = "";
                MessageBox.Show(ex.Message);

            }



        }

        private void rtbK1_16_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            txtmahoa.Clear();
            txtbanro.Clear();
          //  txtKetQua.Clear();
            txtkhoa.Clear();
            txtbanro.Focus();
        }


        private void btnXuatFile_Click(object sender, EventArgs e)
        {
            if (saveFileDialog1.ShowDialog() == DialogResult.OK)
            {
                StreamWriter sw = File.CreateText(saveFileDialog1.FileName);
                sw.WriteLine("Bản rõ M: "+txtbanro.Text);
                sw.WriteLine("Khóa K: " + txtkhoa.Text);
                sw.WriteLine("Bản mã hóa: " + txtmahoa.Text);
                sw.WriteLine("IV: " + txtIV.Text);
                sw.WriteLine("--------------------------------------------Chi tiết------------------------------------------------");
                //sw.WriteLine(txtKetQua.Text);
                sw.Close();
            }
        }
       
        private void button3_Click(object sender, EventArgs e)
        {

            MessageBox.Show("Em chưa làm được phần này");
        }

        private void btnsinhbanro_Click(object sender, EventArgs e)
        {
            txtbanro.Text = "";
            String checking = "0123456789abcdef";
            Random rn = new Random();
            for (int i = 0; i < 16; i++)
            {

                txtbanro.Text += checking[rn.Next(0, checking.Length)];
                txtbanro.Text += checking[rn.Next(0, checking.Length)];
                if (i != 15)
                {
                    txtbanro.Text += " ";
                }
            }
        }

        private void btnsinhK_Click(object sender, EventArgs e)
        {
            txtkhoa.Text = "";
            String checking = "0123456789abcdef";
            Random rn = new Random();
            for (int i = 0; i < 16; i++)
            {

                txtkhoa.Text += checking[rn.Next(0, checking.Length)];
                txtkhoa.Text += checking[rn.Next(0, checking.Length)];
                if (i != 15)
                {
                    txtkhoa.Text += " ";
                }
            }
        }

        private void btnsinhIV_Click(object sender, EventArgs e)
        {
            txtIV.Text = "";
            String checking = "0123456789abcdef";
            Random rn = new Random();
            for (int i = 0; i < 16; i++)
            {

                txtIV.Text += checking[rn.Next(0, checking.Length)];
                txtIV.Text += checking[rn.Next(0, checking.Length)];
                if (i != 15)
                {
                    txtIV.Text += " ";
                }
            }
        }

        private void txtmahoa_TextChanged(object sender, EventArgs e)
        {

        }
    }

   
}
