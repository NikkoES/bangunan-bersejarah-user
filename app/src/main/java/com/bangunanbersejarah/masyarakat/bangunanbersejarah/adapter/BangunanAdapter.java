package com.bangunanbersejarah.masyarakat.bangunanbersejarah.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bangunanbersejarah.masyarakat.bangunanbersejarah.db.NoteHelper;
import com.bumptech.glide.Glide;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.R;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.activity.DetailBangunanActivity;
import com.bangunanbersejarah.masyarakat.bangunanbersejarah.model.Bangunan;

import java.util.List;

/**
 * Created by Nikko Eka Saputra on 4/2/2018.
 */

public class BangunanAdapter extends RecyclerView.Adapter<BangunanAdapter.ViewHolder> {

    private Context context;
    private List<Bangunan> listBangunan;
    private int kode;

    private NoteHelper bangunanHelper;

    public BangunanAdapter(Context context, List<Bangunan> listBangunan, int kode){
        this.context = context;
        this.listBangunan = listBangunan;
        this.kode = kode;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_bangunan, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        bangunanHelper = new NoteHelper(context);
        bangunanHelper.open();

        final Bangunan bangunan = listBangunan.get(position);
        Glide.with(context)
                .load(bangunan.getImageBangunan())
                .placeholder(R.drawable.no_image_icon)
                .into(holder.imageBangunan);
        holder.namaBangunan.setText(bangunan.getNamaBangunan());
        holder.btnBangunan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(kode==1){
                    final CharSequence[] dialogitem = {"Lihat Detail Bangunan", "Tambahkan ke Favorit"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setItems(dialogitem, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int item){
                            switch(item){
                                case 0 : {
                                    Intent i = new Intent(context, DetailBangunanActivity.class);
                                    i.putExtra("id_bangunan", bangunan.getIdBangunan());
                                    i.putExtra("nama_bangunan", bangunan.getNamaBangunan());
                                    i.putExtra("sejarah_bangunan", bangunan.getSejarahBangunan());
                                    i.putExtra("image_bangunan", bangunan.getImageBangunan());
                                    i.putExtra("id_provinsi", bangunan.getIdProvinsi());
                                    i.putExtra("id_daerah", bangunan.getIdDaerah());
                                    i.putExtra("tanggal", bangunan.getTanggal());
                                    i.putExtra("alamat", bangunan.getAlamatBangunan());
                                    context.startActivity(i);
                                    ((Activity) context).overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                                    break;
                                }
                                case 1 : {
                                    bangunanHelper.insert(bangunan);
                                    Toast.makeText(context, "Berhasil ditambahkan ke favorit", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }
                        }
                    });
                    builder.create().show();
                }
                else{
                    final CharSequence[] dialogitem = {"Lihat Detail Bangunan", "Hapus dari Favorit"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setItems(dialogitem, new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int item){
                            switch(item){
                                case 0 : {
                                    Intent i = new Intent(context, DetailBangunanActivity.class);
                                    i.putExtra("id_bangunan", bangunan.getIdBangunan());
                                    i.putExtra("nama_bangunan", bangunan.getNamaBangunan());
                                    i.putExtra("sejarah_bangunan", bangunan.getSejarahBangunan());
                                    i.putExtra("image_bangunan", bangunan.getImageBangunan());
                                    i.putExtra("id_provinsi", bangunan.getIdProvinsi());
                                    i.putExtra("id_daerah", bangunan.getIdDaerah());
                                    i.putExtra("tanggal", bangunan.getTanggal());
                                    i.putExtra("alamat", bangunan.getAlamatBangunan());
                                    context.startActivity(i);
                                    ((Activity) context).overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                                    break;
                                }
                                case 1 : {
                                    bangunanHelper.delete(bangunan.getId());
                                    listBangunan.remove(position);
                                    Toast.makeText(context, "Berhasil dihapus dari favorit", Toast.LENGTH_SHORT).show();
                                    break;
                                }
                            }
                        }
                    });
                    builder.create().show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBangunan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView btnBangunan;
        private ImageView imageBangunan;
        private TextView namaBangunan;

        public ViewHolder(View itemView) {
            super(itemView);

            btnBangunan = (CardView) itemView.findViewById(R.id.cv_bangunan);
            imageBangunan = (ImageView) itemView.findViewById(R.id.image_bangunan);
            namaBangunan = (TextView) itemView.findViewById(R.id.nama_bangunan);
        }
    }
}