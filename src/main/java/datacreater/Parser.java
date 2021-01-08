package datacreater;

import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.ParseException;
import org.apache.hadoop.hive.ql.parse.ParseUtils;

public class Parser {
    public static void main(String[] args) throws ParseException {
        String hql = "-- 目 标 表:[std.sp_ft_fmbn_write_off_detail_a] [富条监管上报-核销明细]\n" +
                "-- 源 表 名:\n" +
                "--        [dv.sat_wangdai_pluton_zeus_acct_write_off_bill_4_l] \n" +
                "--        [dv.sat_wangdai_pluton_zeus_acct_write_off_bill_detail_4_l]\n" +
                "--        [dv.sat_wangdai_pluton_adam_acct_write_off_bill_4_l]\n" +
                "--        [dv.sat_wangdai_pluton_adam_acct_write_off_bill_detail_4_l]\n" +
                "--        [dv.sat_ft_pluton_zeus_acct_loan_bill]\n" +
                "--        [dv.sat_ft_pluton_zeus_pf_category_product]\n" +
                "--        [dv.sat_ft_pluton_zeus_acct_ious]\n" +
                "--        [dv.sat_ft_pluton_zeus_acct_five_classification]\n" +
                "--        [dv.sat_wangdai_pluton_zeus_pf_category_business]\n" +
                "-- 源表码值：\n" +
                "-- 加载策略: [03] (注,00:其他 01:覆盖,02:更新,03:追加,04:拉链)\n" +
                "-- 运行周期: [1] (注, 1:天,2:星期,3:旬,4:月,5:季,6:半年,7:年，00:其他)\n" +
                "-- 脚本功能: 富条监管上报-核销明细\n" +
                "-- 创建时间: 2020-09-17\n" +
                "-- 文 件 名: sp_ft_fmbn_write_off_detail_a.hql\n" +
                "-- 作    者: xiangtao\n" +
                "-- 修改记录:\n" +
                "\n" +
                "\n" +
                "\n" +
                "INSERT INTO pdm.job_log_detail (data_date,tab_title,tab_name,job_step,job_time,job_info)\n" +
                "SELECT '2020-09-24','std','sp_ft_fmbn_write_off_detail_a','00',current_timestamp(),'start' ;\n" +
                "\n" +
                "--清空数据\n" +
                "TRUNCATE TABLE std.sp_ft_fmbn_write_off_detail_a ;\n" +
                "\n" +
                "\n" +
                "--创建临时表 std.temp_ft_write_off_pluton_zeus_acct_write_off_bill_4_l\n" +
                "DROP TABLE IF EXISTS std.temp_ft_write_off_pluton_zeus_acct_write_off_bill_4_l;\n" +
                "\n" +
                "\n" +
                "CREATE TEMPORARY  table std.temp_ft_write_off_pluton_zeus_acct_write_off_bill_4_l as\n" +
                "SELECT t.*\n" +
                "  FROM\n" +
                "        (\n" +
                "         SELECT t01.*\n" +
                "         ,row_number() over(partition by t01.hub_wangdai_pluton_zeus_acct_write_off_bill_4_l_key order by sat_load_dts desc) as rown\n" +
                "          FROM dv.sat_wangdai_pluton_zeus_acct_write_off_bill_4_l as t01 WHERE sat_load_dts<='2020-09-24'\n" +
                "        )  as t\n" +
                "  WHERE t.rown=1\n" +
                "    AND t.sat_del_flag='0'\n" +
                ";\n" +
                "\n" +
                "--创建临时表 std.temp_ft_write_off_pluton_zeus_acct_write_off_bill_detail_4_l\n" +
                "DROP TABLE IF EXISTS std.temp_ft_write_off_pluton_zeus_acct_write_off_bill_detail_4_l;\n" +
                "CREATE TEMPORARY table std.temp_ft_write_off_pluton_zeus_acct_write_off_bill_detail_4_l as\n" +
                "SELECT t.write_off_bill_id,\n" +
                "       sum(case when t.write_off_subject='PRI' then t.write_off_subject_amt else 0 end) pri_writeoff_amt,--本金\n" +
                "\t   sum(case when t.write_off_subject='INT' then t.write_off_subject_amt else 0 end) int_writeoff_amt,--利息\n" +
                "\t   sum(case when t.write_off_subject='PIN' then t.write_off_subject_amt else 0 end) pin_writeoff_amt--罚息\n" +
                "  FROM\n" +
                "        (\n" +
                "         SELECT t01.*\n" +
                "         ,row_number() over(partition by t01.hub_wangdai_pluton_zeus_acct_write_off_bill_detail_4_l_key order by sat_load_dts desc) as rown\n" +
                "          FROM dv.sat_wangdai_pluton_zeus_acct_write_off_bill_detail_4_l as t01 WHERE sat_load_dts<='2020-09-24'\n" +
                "        )  as t\n" +
                "  WHERE t.rown=1\n" +
                "    AND t.sat_del_flag='0'\n" +
                "  GROUP BY t.write_off_bill_id\t\n" +
                ";\n" +
                "\n" +
                "\n" +
                "--创建临时表 std.temp_ft_write_off_pluton_adam_acct_write_off_bill_4_l\n" +
                "DROP TABLE IF EXISTS std.temp_ft_write_off_pluton_adam_acct_write_off_bill_4_l;\n" +
                "CREATE TEMPORARY  table std.temp_ft_write_off_pluton_adam_acct_write_off_bill_4_l as\n" +
                "SELECT t.*\n" +
                "  FROM\n" +
                "        (\n" +
                "         SELECT t01.*\n" +
                "         ,row_number() over(partition by t01.hub_wangdai_pluton_adam_acct_write_off_bill_4_l_key order by sat_load_dts desc) as rown\n" +
                "          FROM dv.sat_wangdai_pluton_adam_acct_write_off_bill_4_l as t01 WHERE sat_load_dts<='2020-09-24'\n" +
                "        )  as t\n" +
                "  WHERE t.rown=1\n" +
                "    AND t.sat_del_flag='0'\n" +
                ";\n" +
                "\n" +
                "--创建临时表 std.temp_ft_write_off_pluton_adam_acct_write_off_bill_detail_4_l\n" +
                "DROP TABLE IF EXISTS std.temp_ft_write_off_pluton_adam_acct_write_off_bill_detail_4_l;\n" +
                "CREATE TEMPORARY table std.temp_ft_write_off_pluton_adam_acct_write_off_bill_detail_4_l as\n" +
                "SELECT t.write_off_bill_id,\n" +
                "       sum(case when t.write_off_subject='PRI' then t.write_off_subject_amt else 0 end) pri_writeoff_amt,--本金\n" +
                "\t   sum(case when t.write_off_subject='INT' then t.write_off_subject_amt else 0 end) int_writeoff_amt,--利息\n" +
                "\t   sum(case when t.write_off_subject='PIN' then t.write_off_subject_amt else 0 end) pin_writeoff_amt--罚息\n" +
                "  FROM\n" +
                "        (\n" +
                "         SELECT t01.*\n" +
                "         ,row_number() over(partition by t01.hub_wangdai_pluton_adam_acct_write_off_bill_detail_4_l_key order by sat_load_dts desc) as rown\n" +
                "          FROM dv.sat_wangdai_pluton_adam_acct_write_off_bill_detail_4_l as t01 WHERE sat_load_dts<='2020-09-24'\n" +
                "        )  as t\n" +
                "  WHERE t.rown=1\n" +
                "    AND t.sat_del_flag='0'\n" +
                "  GROUP BY t.write_off_bill_id\t\n" +
                ";\n" +
                "\n" +
                "--创建临时表 std.temp_ft_write_off_acct_acct_loan_bill\n" +
                " DROP TABLE IF EXISTS std.temp_ft_write_off_acct_acct_loan_bill;\n" +
                " CREATE TEMPORARY  table std.temp_ft_write_off_acct_acct_loan_bill as\n" +
                " SELECT t.*\n" +
                "   FROM (\n" +
                "          SELECT t01.*\n" +
                "          ,row_number() over(partition by  t01.hub_ft_pluton_zeus_acct_loan_bill_key order by sat_load_dts desc) as rown\n" +
                "           FROM dv.sat_ft_pluton_zeus_acct_loan_bill as t01 WHERE sat_load_dts<='2020-09-24'\n" +
                "         )  as t\n" +
                "  WHERE t.rown=1\n" +
                " ;\n" +
                " \n" +
                "--创建临时表 std.temp_ft_write_off_pf_category_product\n" +
                " DROP TABLE IF EXISTS std.temp_ft_write_off_pf_category_product;\n" +
                " CREATE TEMPORARY  table std.temp_ft_write_off_pf_category_product as\n" +
                " SELECT t.*\n" +
                "    FROM (SELECT t01.* ,row_number() over(partition by  t01.hub_ft_pluton_zeus_pf_category_product_key order by sat_load_dts desc) as rown\n" +
                "            FROM dv.sat_ft_pluton_zeus_pf_category_product as t01\n" +
                "            WHERE sat_load_dts<='2020-09-24'\n" +
                "          )  as t\n" +
                "  WHERE t.rown=1\n" +
                " ; \n" +
                " \n" +
                "--创建临时表 std.temp_ft_write_off_acct_ious\n" +
                "DROP TABLE IF EXISTS std.temp_ft_write_off_acct_ious;\n" +
                "CREATE TEMPORARY  table std.temp_ft_write_off_acct_ious as\n" +
                "SELECT t.*\n" +
                "  FROM (\n" +
                "        SELECT t01.*\n" +
                "        ,row_number() over(partition by  t01.hub_ft_pluton_zeus_acct_ious_key order by sat_load_dts desc) as rown\n" +
                "         FROM dv.sat_ft_pluton_zeus_acct_ious as t01 WHERE sat_load_dts<='2020-09-24'\n" +
                "        )  as t\n" +
                " WHERE t.rown=1\n" +
                "; \n" +
                "\n" +
                "--创建临时表 std.temp_ft_write_off_acct_five_classification\n" +
                "DROP TABLE IF EXISTS std.temp_ft_write_off_acct_five_classification;\n" +
                "CREATE TEMPORARY  table std.temp_ft_write_off_acct_five_classification as\n" +
                "SELECT t.*\n" +
                "  FROM (\n" +
                "          SELECT t01.*\n" +
                "          ,row_number() over(partition by  t01.hub_ft_pluton_zeus_acct_five_classification_key order by sat_load_dts desc) as rown\n" +
                "           FROM dv.sat_ft_pluton_zeus_acct_five_classification as t01 WHERE sat_load_dts<='2020-09-24'\n" +
                "        )  as t\n" +
                " WHERE t.rown=1\n" +
                ";\n" +
                "\n" +
                "--创建临时表 std.temp_ft_write_off_pf_category_business\n" +
                "DROP TABLE IF EXISTS std.temp_ft_write_off_pf_category_business;\n" +
                "CREATE TEMPORARY  table std.temp_ft_write_off_pf_category_business as\n" +
                "SELECT t.*\n" +
                "FROM (select t01.* ,row_number() over(partition by  t01.hub_wangdai_pluton_zeus_pf_category_business_key order by sat_load_dts desc) as rown\n" +
                "\t\t FROM dv.sat_wangdai_pluton_zeus_pf_category_business as t01\n" +
                "\t\t WHERE sat_load_dts<='2020-09-24'\n" +
                "\t  )  as t\n" +
                "WHERE t.rown=1\n" +
                ";\n" +
                "\n" +
//                "set hive.vectorized.execution.enabled=false;\n" +
                "\n" +
                "INSERT INTO std.sp_ft_fmbn_write_off_detail_a\n" +
                "(\n" +
                "     load_time\n" +
                "    ,sp_load_dts\n" +
                "    ,busi_date                  --业务日期\n" +
                "\t,serail_no                  --核销明细流水号\n" +
                "\t,loanwriteoffid             --贷款核销申请号\n" +
                "\t,loan_id                    --借据号\n" +
                "\t,mxkmbh                     --明细科目编号\n" +
                "\t,mxkmmc                     --明细科目名称\n" +
                "\t,five_class                 --五级分类\n" +
                "\t,amt_all                    --全额核销贷款金额\n" +
                "\t,amt_part                   --差额核销贷款金额\n" +
                "\t,write_off_date             --核销日期\n" +
                "\t,write_off_time             --核销时间\n" +
                "\t,plan_date                  --还款计划状态\n" +
                "\t,out_flg                    --非应计标识\n" +
                "\t,write_off_amt              --核销金额\n" +
                "\t,write_off_prin_amt         --本金核销金额\n" +
                "\t,write_off_int_amt          --利息核销金额\n" +
                "\t,write_off_pnlt_amt         --罚息核销金额\n" +
                "\t,write_off_cmpd_amt         --复利核销金额\n" +
                "\t,write_off_fee_amt          --费用核销金额\n" +
                "\t,owner_write_off_amt        --富民核销金额\n" +
                "\t,owner_write_off_prin_amt   --富民核销本金\n" +
                "\t,owner_write_off_int_amt    --富民核销利息\n" +
                "\t,owner_write_off_pnlt_amt   --富民核销罚息\n" +
                "\t,owner_write_off_cmpd_amt   --富民核销复利\n" +
                "\t,owner_write_off_fee_amt    --富民核销费用\n" +
                "\t,fund_write_off_amt         --资金方核销金额\n" +
                "\t,fund_write_off_prin_amt    --资金方核销本金\n" +
                "\t,fund_write_off_int_amt     --资金方核销利息\n" +
                "\t,fund_write_off_pnlt_amt    --资金方核销罚息\n" +
                "\t,fund_write_off_cmpd_amt    --资金方核销复利\n" +
                "\t,fund_write_off_fee_amt     --资金方核销费用\n" +
                "\t,in_account_date            --核销入账日期\n" +
                "\t,product_no                 --产品编号/资产渠道编号\n" +
                "\t,fund_channel_no            --资金渠道编号\n" +
                "\t,bzh                        --备注\n" +
                "\t,channel_business_id        --业务渠道标识\n" +
                ")\n" +
                "SELECT\n" +
                "        date_format(current_timestamp(),'yyyy-MM-dd HH:mm:ss') AS load_time     -- 数据加载时间\n" +
                "       ,'2020-09-24' sp_load_dts            --增量时间\n" +
                "       ,t01.write_off_date busi_date                  --业务日期\n" +
                "\t   ,t01.in_request_id serail_no                  --核销明细流水号\n" +
                "\t   ,t01.loan_write_off_order_id loanwriteoffid             --贷款核销申请号\n" +
                "\t   ,t02.ious_id loan_id                    --借据号\n" +
                "\t   ,case when t03.ious_mark='1' then coalesce(t04.union_accounting_template_id,'')\n" +
                "             else coalesce(t04.accounting_template_id,'')\n" +
                "        end mxkmbh                     --明细科目编号\n" +
                "\t   ,t04.accounting_template_name mxkmmc                     --明细科目名称\n" +
                "\t   ,case when t05.five_classification='1' then 'FQ01'\n" +
                "\t\t\t when t05.five_classification='2' then 'FQ02'\n" +
                "\t\t\t when t05.five_classification='3' then 'FQ03'\n" +
                "\t\t\t when t05.five_classification='4' then 'FQ04'\n" +
                "\t\t\t when t05.five_classification='5' then 'FQ05'\n" +
                "\t\t\t else ''\n" +
                "\t\tend five_class                 --五级分类\n" +
                "\t   ,coalesce(t01.write_off_amt,'0') amt_all                    --全额核销贷款金额\n" +
                "\t   ,'0' amt_part                   --差额核销贷款金额\n" +
                "\t   ,regexp_replace(t01.write_off_date,'-','') write_off_date             --核销日期\n" +
                "\t   ,regexp_replace(substr(t01.create_date,12,8),':','') write_off_time             --核销时间\n" +
                "\t   ,'2' plan_date                  --还款计划状态\n" +
                "\t   ,'1' out_flg                    --非应计标识\n" +
                "\t   ,coalesce(t01.write_off_amt,'0') write_off_amt              --核销金额\n" +
                "\t   ,coalesce(t06.pri_writeoff_amt,'0') write_off_prin_amt         --本金核销金额\n" +
                "\t   ,coalesce(t06.int_writeoff_amt,'0') write_off_int_amt          --利息核销金额\n" +
                "\t   ,coalesce(t06.pin_writeoff_amt,'0') write_off_pnlt_amt         --罚息核销金额\n" +
                "\t   ,'0' write_off_cmpd_amt         --复利核销金额\n" +
                "\t   ,coalesce(t01.write_off_amt,'0') write_off_fee_amt          --费用核销金额\n" +
                "\t   ,case when t03.ious_mark='1' then coalesce(t01.write_off_amt,'0')-coalesce(t08.write_off_amt,'0')\n" +
                "\t         else coalesce(t01.write_off_amt,'0')\n" +
                "\t    end owner_write_off_amt        --富民核销金额\n" +
                "\t   ,case when t03.ious_mark='1' then coalesce(t06.pri_writeoff_amt,'0')-coalesce(t07.pri_writeoff_amt,'0')\n" +
                "\t         else coalesce(t06.pri_writeoff_amt,'0')\n" +
                "\t    end owner_write_off_prin_amt   --富民核销本金\n" +
                "\t   ,case when t03.ious_mark='1' then coalesce(t06.int_writeoff_amt,'0')-coalesce(t07.int_writeoff_amt,'0')\n" +
                "\t         else coalesce(t06.int_writeoff_amt,'0')\n" +
                "\t    end owner_write_off_int_amt    --富民核销利息\n" +
                "\t   ,case when t03.ious_mark='1' then coalesce(t06.pin_writeoff_amt,'0')-coalesce(t07.pin_writeoff_amt,'0')\n" +
                "\t         else coalesce(t06.pin_writeoff_amt,'0')\n" +
                "\t    end owner_write_off_pnlt_amt   --富民核销罚息\n" +
                "\t   ,'0' owner_write_off_cmpd_amt   --富民核销复利\n" +
                "\t   ,case when t03.ious_mark='1' then coalesce(t01.write_off_amt,'0')-coalesce(t08.write_off_amt,'0')\n" +
                "\t         else coalesce(t01.write_off_amt,'0')\n" +
                "\t    end owner_write_off_fee_amt    --富民核销费用\n" +
                "\t   ,coalesce(t08.write_off_amt,'0') fund_write_off_amt         --资金方核销金额\n" +
                "\t   ,coalesce(t07.pri_writeoff_amt,'0') fund_write_off_prin_amt    --资金方核销本金\n" +
                "\t   ,coalesce(t07.int_writeoff_amt,'0') fund_write_off_int_amt     --资金方核销利息\n" +
                "\t   ,coalesce(t07.pin_writeoff_amt,'0') fund_write_off_pnlt_amt    --资金方核销罚息\n" +
                "\t   ,'0' fund_write_off_cmpd_amt    --资金方核销复利\n" +
                "\t   ,coalesce(t08.write_off_amt,'0') fund_write_off_fee_amt     --资金方核销费用\n" +
                "\t   ,regexp_replace('2020-09-24','-','') in_account_date            --核销入账日期\n" +
                "\t   ,t09.business_definition_val product_no                 --产品编号/资产渠道编号\n" +
                "\t   ,'0' fund_channel_no            --资金渠道编号\n" +
                "\t   ,'' bzh                        --备注\n" +
                "\t   ,'A05' channel_business_id        --业务渠道标识\n" +
                "  FROM\n" +
                "       std.temp_ft_write_off_pluton_zeus_acct_write_off_bill_4_l t01 \n" +
                "  LEFT JOIN\n" +
                "       std.temp_ft_write_off_acct_acct_loan_bill t02\n" +
                "    ON\n" +
                "       t01.loan_bill_id=t02.loan_bill_id\n" +
                "  LEFT JOIN\n" +
                "       std.temp_ft_write_off_acct_ious t03 \n" +
                "\tON\n" +
                "\t   t02.ious_id=t03.ious_id\n" +
                "  LEFT JOIN\n" +
                "       std.temp_ft_write_off_pf_category_product t04\n" +
                "    ON\n" +
                "       t03.product_classify_id=t04.product_classify_id\n" +
                "  LEFT JOIN\n" +
                "       std.temp_ft_write_off_acct_five_classification t05\n" +
                "    ON\n" +
                "       t03.ious_id=t05.ious_id\n" +
                "  LEFT JOIN\n" +
                "       std.temp_ft_write_off_pluton_zeus_acct_write_off_bill_detail_4_l t06\n" +
                "\tON\n" +
                "\t   t01.write_off_bill_id=t06.write_off_bill_id\n" +
                "  LEFT JOIN\n" +
                "       std.temp_ft_write_off_pluton_adam_acct_write_off_bill_detail_4_l t07\n" +
                "\tON\n" +
                "\t   t01.write_off_bill_id=t07.write_off_bill_id\n" +
                "  LEFT JOIN\n" +
                "       std.temp_ft_write_off_pluton_adam_acct_write_off_bill_4_l t08\n" +
                "\tON\n" +
                "\t   t01.write_off_bill_id=t08.write_off_bill_id\n" +
                "  LEFT JOIN\n" +
                "        (\n" +
                "\t\t SELECT product_classify_id,business_definition_val\n" +
                "           FROM std.temp_ft_write_off_pf_category_business\n" +
                "          WHERE business_definition_name = 'BUSINESS_CODE'\n" +
                "        )   t09\n" +
                "    ON\n" +
                "         t03.product_classify_id=t09.product_classify_id\n" +
                "\n" +
                ";\n" +
                "\n" +
                "\n" +
                "\n" +
                "--输出加工完成事件\n" +
                "INSERT OVERWRITE  DIRECTORY '/user/etl/ctl/std/sp/ft/OK/2020-09-24/sp_ft_fmbn_write_off_detail_a' SELECT '';\n" +
                "\n" +
                "--日志记录\n" +
                "INSERT INTO pdm.job_log_detail (data_date,tab_title,tab_name,job_step,job_time,job_info)\n" +
                "SELECT '2020-09-24','std','sp_ft_fmbn_write_off_detail_a','99',current_timestamp(),'end';";

//        SQLStatementParser sqlStatementParser = SQLParserUtils.createSQLStatementParser(hql, DbType.hive);
//        List<SQLStatement> sqlStatements = SQLUtils.parseStatements(hql, DbType.mysql);
//        Assert.state(sqlStatements.size() == 24,"解析错误");
        String qqq = "set hive.vectorized.execution.enabled=false;";
        String[] split = hql.split(";");
        ASTNode parse1 = ParseUtils.parse(qqq);
        for(int i = 0; i < split.length; i++){
            ASTNode parse = ParseUtils.parse(split[i]);
            System.out.println(parse);
        }
    }
}

