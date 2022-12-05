namespace MahoaDES
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.button3 = new System.Windows.Forms.Button();
            this.txtkhoa = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.btnXuatFile = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.txtbanro = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtmahoa = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.btnMaHoa = new System.Windows.Forms.Button();
            this.saveFileDialog1 = new System.Windows.Forms.SaveFileDialog();
            this.label = new System.Windows.Forms.Label();
            this.txtIV = new System.Windows.Forms.TextBox();
            this.btnsinhbanro = new System.Windows.Forms.Button();
            this.btnsinhK = new System.Windows.Forms.Button();
            this.btnsinhIV = new System.Windows.Forms.Button();
            this.richTextBox1 = new System.Windows.Forms.RichTextBox();
            this.groupBox2.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox2
            // 
            this.groupBox2.AutoSize = true;
            this.groupBox2.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.groupBox2.Controls.Add(this.richTextBox1);
            this.groupBox2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.groupBox2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBox2.Location = new System.Drawing.Point(360, 0);
            this.groupBox2.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Padding = new System.Windows.Forms.Padding(9, 4, 4, 4);
            this.groupBox2.Size = new System.Drawing.Size(827, 574);
            this.groupBox2.TabIndex = 12;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Output";
            // 
            // groupBox1
            // 
            this.groupBox1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.groupBox1.Controls.Add(this.btnsinhIV);
            this.groupBox1.Controls.Add(this.btnsinhK);
            this.groupBox1.Controls.Add(this.btnsinhbanro);
            this.groupBox1.Controls.Add(this.txtIV);
            this.groupBox1.Controls.Add(this.label);
            this.groupBox1.Controls.Add(this.button3);
            this.groupBox1.Controls.Add(this.txtkhoa);
            this.groupBox1.Controls.Add(this.button1);
            this.groupBox1.Controls.Add(this.btnXuatFile);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.txtbanro);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.txtmahoa);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.btnMaHoa);
            this.groupBox1.Dock = System.Windows.Forms.DockStyle.Left;
            this.groupBox1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBox1.Location = new System.Drawing.Point(0, 0);
            this.groupBox1.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Padding = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.groupBox1.Size = new System.Drawing.Size(360, 574);
            this.groupBox1.TabIndex = 11;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Input";
            // 
            // button3
            // 
            this.button3.BackColor = System.Drawing.Color.Orange;
            this.button3.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.button3.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Red;
            this.button3.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button3.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button3.Location = new System.Drawing.Point(193, 472);
            this.button3.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(112, 37);
            this.button3.TabIndex = 12;
            this.button3.Text = "Giải Mã";
            this.button3.UseVisualStyleBackColor = false;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // txtkhoa
            // 
            this.txtkhoa.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtkhoa.Location = new System.Drawing.Point(86, 138);
            this.txtkhoa.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtkhoa.Multiline = true;
            this.txtkhoa.Name = "txtkhoa";
            this.txtkhoa.Size = new System.Drawing.Size(251, 45);
            this.txtkhoa.TabIndex = 1;
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.Color.Orange;
            this.button1.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.button1.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Red;
            this.button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.button1.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button1.Location = new System.Drawing.Point(60, 517);
            this.button1.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(112, 37);
            this.button1.TabIndex = 9;
            this.button1.Text = "Clear";
            this.button1.UseVisualStyleBackColor = false;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // btnXuatFile
            // 
            this.btnXuatFile.BackColor = System.Drawing.Color.Orange;
            this.btnXuatFile.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btnXuatFile.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Red;
            this.btnXuatFile.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnXuatFile.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnXuatFile.Location = new System.Drawing.Point(193, 517);
            this.btnXuatFile.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.btnXuatFile.Name = "btnXuatFile";
            this.btnXuatFile.Size = new System.Drawing.Size(112, 37);
            this.btnXuatFile.TabIndex = 8;
            this.btnXuatFile.Text = "Save";
            this.btnXuatFile.UseVisualStyleBackColor = false;
            this.btnXuatFile.Click += new System.EventHandler(this.btnXuatFile_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(6, 52);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(63, 22);
            this.label2.TabIndex = 5;
            this.label2.Text = "Bản rõ";
            // 
            // txtbanro
            // 
            this.txtbanro.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtbanro.Location = new System.Drawing.Point(86, 27);
            this.txtbanro.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtbanro.Multiline = true;
            this.txtbanro.Name = "txtbanro";
            this.txtbanro.Size = new System.Drawing.Size(251, 47);
            this.txtbanro.TabIndex = 0;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(6, 265);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(69, 22);
            this.label3.TabIndex = 7;
            this.label3.Text = "Mã hóa";
            // 
            // txtmahoa
            // 
            this.txtmahoa.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtmahoa.Location = new System.Drawing.Point(86, 244);
            this.txtmahoa.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtmahoa.Multiline = true;
            this.txtmahoa.Name = "txtmahoa";
            this.txtmahoa.Size = new System.Drawing.Size(251, 43);
            this.txtmahoa.TabIndex = 2;
            this.txtmahoa.TextChanged += new System.EventHandler(this.txtmahoa_TextChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(7, 161);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(71, 22);
            this.label1.TabIndex = 6;
            this.label1.Text = "Khóa K";
            // 
            // btnMaHoa
            // 
            this.btnMaHoa.BackColor = System.Drawing.Color.Orange;
            this.btnMaHoa.FlatAppearance.BorderColor = System.Drawing.Color.White;
            this.btnMaHoa.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Red;
            this.btnMaHoa.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMaHoa.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnMaHoa.Location = new System.Drawing.Point(60, 472);
            this.btnMaHoa.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.btnMaHoa.Name = "btnMaHoa";
            this.btnMaHoa.Size = new System.Drawing.Size(112, 37);
            this.btnMaHoa.TabIndex = 3;
            this.btnMaHoa.Text = "Mã Hóa";
            this.btnMaHoa.UseVisualStyleBackColor = false;
            this.btnMaHoa.Click += new System.EventHandler(this.btnMaHoa_Click);
            // 
            // saveFileDialog1
            // 
            this.saveFileDialog1.Filter = "*.txt|*.txt";
            // 
            // label
            // 
            this.label.AutoSize = true;
            this.label.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label.Location = new System.Drawing.Point(12, 377);
            this.label.Name = "label";
            this.label.Size = new System.Drawing.Size(26, 22);
            this.label.TabIndex = 14;
            this.label.Text = "IV";
            // 
            // txtIV
            // 
            this.txtIV.Font = new System.Drawing.Font("Times New Roman", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtIV.Location = new System.Drawing.Point(86, 358);
            this.txtIV.Margin = new System.Windows.Forms.Padding(4);
            this.txtIV.Multiline = true;
            this.txtIV.Name = "txtIV";
            this.txtIV.Size = new System.Drawing.Size(251, 41);
            this.txtIV.TabIndex = 15;
            // 
            // btnsinhbanro
            // 
            this.btnsinhbanro.BackColor = System.Drawing.Color.Chartreuse;
            this.btnsinhbanro.FlatAppearance.BorderSize = 0;
            this.btnsinhbanro.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnsinhbanro.Font = new System.Drawing.Font("Consolas", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnsinhbanro.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.btnsinhbanro.Location = new System.Drawing.Point(182, 93);
            this.btnsinhbanro.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnsinhbanro.Name = "btnsinhbanro";
            this.btnsinhbanro.Size = new System.Drawing.Size(137, 39);
            this.btnsinhbanro.TabIndex = 16;
            this.btnsinhbanro.Text = "Sinh bản rõ";
            this.btnsinhbanro.UseVisualStyleBackColor = false;
            this.btnsinhbanro.Click += new System.EventHandler(this.btnsinhbanro_Click);
            // 
            // btnsinhK
            // 
            this.btnsinhK.BackColor = System.Drawing.Color.Chartreuse;
            this.btnsinhK.FlatAppearance.BorderSize = 0;
            this.btnsinhK.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnsinhK.Font = new System.Drawing.Font("Consolas", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnsinhK.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.btnsinhK.Location = new System.Drawing.Point(182, 199);
            this.btnsinhK.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnsinhK.Name = "btnsinhK";
            this.btnsinhK.Size = new System.Drawing.Size(137, 39);
            this.btnsinhK.TabIndex = 17;
            this.btnsinhK.Text = "Sinh Khóa";
            this.btnsinhK.UseVisualStyleBackColor = false;
            this.btnsinhK.Click += new System.EventHandler(this.btnsinhK_Click);
            // 
            // btnsinhIV
            // 
            this.btnsinhIV.BackColor = System.Drawing.Color.Chartreuse;
            this.btnsinhIV.FlatAppearance.BorderSize = 0;
            this.btnsinhIV.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnsinhIV.Font = new System.Drawing.Font("Consolas", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnsinhIV.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.btnsinhIV.Location = new System.Drawing.Point(182, 405);
            this.btnsinhIV.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnsinhIV.Name = "btnsinhIV";
            this.btnsinhIV.Size = new System.Drawing.Size(137, 37);
            this.btnsinhIV.TabIndex = 18;
            this.btnsinhIV.Text = "Sinh khóa IV";
            this.btnsinhIV.UseVisualStyleBackColor = false;
            this.btnsinhIV.Click += new System.EventHandler(this.btnsinhIV_Click);
            // 
            // richTextBox1
            // 
            this.richTextBox1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.richTextBox1.Location = new System.Drawing.Point(9, 23);
            this.richTextBox1.Name = "richTextBox1";
            this.richTextBox1.Size = new System.Drawing.Size(814, 547);
            this.richTextBox1.TabIndex = 0;
            this.richTextBox1.Text = "";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1187, 574);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "AES";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox2.ResumeLayout(false);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button btnXuatFile;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtmahoa;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnMaHoa;
        public System.Windows.Forms.TextBox txtbanro;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox txtkhoa;
        private System.Windows.Forms.SaveFileDialog saveFileDialog1;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.TextBox txtIV;
        private System.Windows.Forms.Label label;
        private System.Windows.Forms.Button btnsinhIV;
        private System.Windows.Forms.Button btnsinhK;
        private System.Windows.Forms.Button btnsinhbanro;
        private System.Windows.Forms.RichTextBox richTextBox1;
    }
}

