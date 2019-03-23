aa: lw $s1,1($zero)
    lw $s2,2($zero)
cc:add $s3,$s2,$s1
   sw $s3,3($zero)
   sub $s3,$s2,$s1
    sw $s3,4($zero)
   subu $s3,$s2,$s1
    sw $s3,5($zero)
    slt  $s3,$s2,$s1
   sw $s3,6($zero)
    sltu  $s3,$s2,$s1
   sw $s3,7($zero)
   beq $s1,$s2,bb
   j aa
bb:sw $s2,8($zero)
   j cc


